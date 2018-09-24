package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.regexp.internal.recompile;

import model.User;
import utility.ConnectionProvider;

public class UserDAO {
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement ps;

	public UserDAO() {
		// TODO Auto-generated constructor stub
	}

	public boolean validateAccountNumber(User u) throws SQLException {
		String query = "select * from Account where account_num1 in(select account_num from user_account_num where id=? )";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, u.getUserId());
		rs = ps.executeQuery();

		boolean result = rs.next();
		return result;
	}

	public void insertUser(User u) throws SQLException {
		String query = "insert into user_reg values (?,?,?,?,?,?,?)";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, u.getfName());
		ps.setString(2, u.getlName());
		ps.setString(3, u.getAddress());
		ps.setString(4, u.getQue());
		ps.setString(5, u.getAns());
		ps.setString(6, u.getUserId());
		ps.setString(7, u.getPassword());
		rs = ps.executeQuery();

	}

	public boolean validateUser(String username, String password) throws SQLException {
		String query = "select * from user_reg where id1=? and password=?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, username);
		ps.setString(2, password);
		rs = ps.executeQuery();
		boolean result = rs.next();
		return result;

	}

	public boolean forgetPasssword(String userid, String que, String answer) throws SQLException {
		String query = "select * from user_reg where id1=? and que=? and ans=?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, userid);
		ps.setString(2, que);
		ps.setString(3, answer);
		rs = ps.executeQuery();
		boolean result = rs.next();
		System.out.println(result);
		return result;

	}

	public boolean changePassword(String password, String userid) throws SQLException {
		String query = "update user_reg set password=? where id1=?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, password);
		ps.setString(2, userid);
		rs = ps.executeQuery();
		boolean result = rs.next();
		System.out.println(result);
		return result;

	}

	public ResultSet accountype(String userid) throws SQLException {
		String query = "select account_type from account where ACCOUNT_NUM1 in (select account_num from user_account_num where id=?)";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, userid);
		rs = ps.executeQuery();

		return rs;

	}

	public boolean validateTransactionPassword(String accountnum, String password) throws SQLException {
		String query = "select * from Account where account_num1=? and transaction_password=?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, accountnum);
		ps.setString(2, password);
		rs = ps.executeQuery();

		boolean result = rs.next();
		return result;
	}

	public boolean validateReceiverAccountNumber(String accountnum) throws SQLException {
		String query = "select * from Account where account_num1 =?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, accountnum);
		rs = ps.executeQuery();

		boolean result = rs.next();
		return result;
	}

	public String datel() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd" );
		Date date = new Date();
		String s = dateFormat.format(date);
		return s;
	}

	public void fundTransfer(String accountnum1, String accountnum2, String amount) throws SQLException {
		java.sql.Date sqlDate = java.sql.Date.valueOf(datel());
		
		String query = "insert into transaction values(?,?,?,?)";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, accountnum1);
		ps.setString(2, accountnum2);
		ps.setDate(3, sqlDate);
		ps.setString(4, amount);
		rs = ps.executeQuery();

	}

	public void deposit(String accountnum2, String amount) throws SQLException {
		con = ConnectionProvider.getConnection();
		String query = "select account_type from account where account_num1=?";
		ps = con.prepareStatement(query);
		ps.setString(1, accountnum2);
		rs = ps.executeQuery();
		rs.next();
		String type = rs.getString(1);
		if (type.equalsIgnoreCase("salary")) {

			String query2 = "update SALARY_ACCOUNT set sbalance=sbalance+? where saccount_num=?";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, amount);
			ps.setString(2, accountnum2);
			rs = ps.executeQuery();
			rs.next();
		} else if (type.equalsIgnoreCase("current")) {
			String query2 = "update CURRENT_ACCOUNT set cbalance=cbalance+? where caccount_num=?";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, amount);
			ps.setString(2, accountnum2);
			rs = ps.executeQuery();
			rs.next();
		} else if (type.equalsIgnoreCase("saving")) {
			String query2 = "update SALARY_ACCOUNT set svbalance=svbalance+? where svaccount_num=?";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, amount);
			ps.setString(2, accountnum2);
			rs = ps.executeQuery();
			rs.next();
		}

	}

	public void withdrawl(String accountnum1, String amount) throws SQLException {
		con = ConnectionProvider.getConnection();
		String query = "select account_type from account where account_num1=?";
		ps = con.prepareStatement(query);
		ps.setString(1, accountnum1);
		rs = ps.executeQuery();
		rs.next();
		String type = rs.getString(1);
		if (type.equalsIgnoreCase("salary")) {

			String query2 = "update SALARY_ACCOUNT set sbalance=sbalance-? where saccount_num=?";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, amount);
			ps.setString(2, accountnum1);
			rs = ps.executeQuery();
			rs.next();
		} else if (type.equalsIgnoreCase("current")) {
			String query2 = "update CURRENT_ACCOUNT set cbalance=cbalance-? where caccount_num=?";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, amount);
			ps.setString(2, accountnum1);
			rs = ps.executeQuery();
			rs.next();
		} else if (type.equalsIgnoreCase("saving")) {
			String query2 = "update SAVING_ACCOUNT set svbalance=svbalance-? where svaccount_num=?";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, amount);
			ps.setString(2, accountnum1);
			rs = ps.executeQuery();
			rs.next();
		}

	}

	public ResultSet showAccountDetail(String type, String userid) throws SQLException {

		if (type.equalsIgnoreCase("salary")) {

			String query2 = "select saccount_num,sbalance from SALARY_ACCOUNT  where saccount_num in (select account_num from user_account_num where id=?)";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			/*
			 * rs.next();
			 * System.out.println("account="+rs.getString(1)+"balance="+rs.
			 * getString(2));
			 */
			return rs;
		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select caccount_num,cbalance from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?)";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			/*
			 * rs.next();
			 * System.out.println("account="+rs.getString(1)+"balance="+rs.
			 * getString(2));
			 */
			return rs;
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select svaccount_num,svbalance from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?)";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			/*
			 * rs.next();
			 * System.out.println("account="+rs.getString(1)+"balance="+rs.
			 * getString(2));
			 */
			return rs;
		}

		return rs;
	}

	public ResultSet showTransaction(String type, String userid) throws SQLException {
		if (type.equalsIgnoreCase("salary")) {

			String query2 = "select * from Transaction where account_num_sender in   (select saccount_num from SALARY_ACCOUNT  where saccount_num in (select account_num from user_account_num where id=?))";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			/*
			 * rs.next();
			 * System.out.println("account="+rs.getString(1)+"balance="+rs.
			 * getString(2));
			 */
			return rs;
		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select * from Transaction where account_num_sender in   (select caccount_num from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?))";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			/*
			 * rs.next();
			 * System.out.println("account="+rs.getString(1)+"balance="+rs.
			 * getString(2));
			 */
			return rs;
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select * from Transaction where account_num_sender in   (select svaccount_num from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?))";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			/*
			 * rs.next();
			 * System.out.println("account="+rs.getString(1)+"balance="+rs.
			 * getString(2));
			 */
			return rs;
		}
		return rs;
  
	}
}
