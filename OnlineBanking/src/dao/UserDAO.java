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
		String query = "insert into user_reg values (?,?,?,?,?,?,?,?)";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, u.getfName());
		ps.setString(2, u.getlName());
		ps.setString(3, u.getAddress());
		ps.setString(4, u.getQue());
		ps.setString(5, u.getAns());
		ps.setString(6, u.getUserId());
		ps.setString(7, u.getPassword());
		ps.setInt(8, 0);
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String s = dateFormat.format(date);
		return s;
	}

	public void fundTransfer(String accountnum1, String accountnum2, String amount) throws SQLException {
		java.sql.Date sqlDate = java.sql.Date.valueOf(datel());

		String query = "insert into transaction values(?,?,?,?,ref_seq.Nextval)";
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

			return rs;
		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select caccount_num,cbalance from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?)";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select svaccount_num,svbalance from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?)";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();

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

			return rs;
		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select * from Transaction where account_num_sender in   (select caccount_num from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?))";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select * from Transaction where account_num_sender in   (select svaccount_num from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?))";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		}
		return rs;

	}

	public ResultSet ministatement(String type, String userid) throws SQLException {

		if (type.equalsIgnoreCase("salary")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate-1 from dual) AND ROWNUM<=7  and account_num_sender in   (select saccount_num from SALARY_ACCOUNT  where saccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;

		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate from dual) AND ROWNUM<=7  and account_num_sender in   (select caccount_num from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate from dual) AND ROWNUM<=7  and account_num_sender in   (select svaccount_num from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		}
		return rs;

	}

	public ResultSet threemonth(String type, String userid) throws SQLException {

		if (type.equalsIgnoreCase("salary")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate from dual) AND ROWNUM<=7  and account_num_sender in   (select saccount_num from SALARY_ACCOUNT  where saccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;

		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate from dual) AND ROWNUM<=7  and account_num_sender in   (select caccount_num from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate from dual) AND ROWNUM<=7  and account_num_sender in   (select svaccount_num from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		}
		return rs;

	}

	public ResultSet onemonth(String type, String userid) throws SQLException {
		System.out.println("one month");

		if (type.equalsIgnoreCase("salary")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate from dual) AND ROWNUM<=7  and account_num_sender in   (select saccount_num from SALARY_ACCOUNT  where saccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;

		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate from dual) AND ROWNUM<=7  and account_num_sender in   (select caccount_num from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select * from TRANSACTION where date1 <(select sysdate from dual) AND ROWNUM<=7  and account_num_sender in   (select svaccount_num from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?)) order by date1 desc";

			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);

			ps.setString(1, userid);
			rs = ps.executeQuery();

			return rs;
		}
		return rs;

	}
	
	public ResultSet selectCountLogin(String userid) throws SQLException
	{
		String query="select count_login from user_reg where id1=?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		
		ps.setString(1, userid);
		rs = ps.executeQuery();
		return rs;
        
	}
	public ResultSet increment(String userid) throws SQLException
	{
		String query="update user_reg set count_login=count_login+1 where id1=?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		
		ps.setString(1, userid);
		rs = ps.executeQuery();
		return rs;
        
	}
	public ResultSet setCountLoginZero(String userid) throws SQLException
	{
		String query="update user_reg set count_login='0' where id1=?";
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement(query);
		
		ps.setString(1, userid);
		rs = ps.executeQuery();
		return rs;
        
	}
	
	
	public void chequeBookRequest(String type, String userid) throws SQLException {
		String accountnum="";
		java.sql.Date sqlDate = java.sql.Date.valueOf(datel());
		if (type.equalsIgnoreCase("salary")) {

			String query2 = "select saccount_num,sbalance from SALARY_ACCOUNT  where saccount_num in (select account_num from user_account_num where id=?)";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
            while(rs.next())
            {
            	accountnum=(String)rs.getString(1);
            	
            }
            String query="insert into cheque_Book_Request values(?,cheque_ref.nextval,?,?)";
            ps=con.prepareStatement(query);
            ps.setString(1, accountnum);
            ps.setDate(2, sqlDate);
            ps.setString(3,"1");
            rs=ps.executeQuery();
            System.out.println("inserted");
            	
			
		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select caccount_num,cbalance from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?)";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			while(rs.next())
            {
            	accountnum=(String)rs.getString(1);
            	
            }
            String query="insert into cheque_Book_Request values(?,cheque_ref.nextval,?,?)";
            ps=con.prepareStatement(query);
            ps.setString(1, accountnum);
            ps.setDate(2, sqlDate);
            ps.setString(3,"1");
              rs=ps.executeQuery();
            	
			
			
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select svaccount_num,svbalance from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?)";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			while(rs.next())
            {
            	accountnum=(String)rs.getString(1);
            	
            }
            String query="insert into cheque_Book_Request values(?,cheque_ref.nextval,?,?)";
            ps=con.prepareStatement(query);
            ps.setString(1, accountnum);
            ps.setDate(2, sqlDate);
            ps.setString(3,"1");
             rs=ps.executeQuery();
            	
			

		
	}
	}
	public void selectchequeBookRequest(String type, String userid) throws SQLException {
		String accountnum="";
		System.out.println("select");
		con = ConnectionProvider.getConnection();
		java.sql.Date sqlDate = java.sql.Date.valueOf(datel());
		if (type.equalsIgnoreCase("salary")) {

			String query2 = "select CHE_ACCOUNT_NUM  from Cheque_Book_Request where CHE_ACCOUNT_NUM in(select saccount_num from SALARY_ACCOUNT  where saccount_num in (select account_num from user_account_num where id=?))";
			
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
            if(rs.next())
            {
            	accountnum=(String)rs.getString(1);
            	 String query="update cheque_Book_Request set status=?-(select req_date from cheque_Book_Request where che_account_num=?) where che_account_num=?";                                                                                                                                           
            	ps=con.prepareStatement(query);
            	ps.setDate(1, sqlDate);
            	ps.setString(2, accountnum);
            	ps.setString(3, accountnum);
            	ps.executeQuery();
            	
            }
            else
            {
            	chequeBookRequest(type,userid);
            	System.out.println("else");
            }
            
            	
			
		} else if (type.equalsIgnoreCase("current")) {

			String query2 = "select CHE_ACCOUNT_NUM  from Cheque_Book_Request where CHE_ACCOUNT_NUM in(select caccount_num from CURRENT_ACCOUNT  where caccount_num in (select account_num from user_account_num where id=?))";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next())
            {
            	accountnum=(String)rs.getString(1);
            	 String query="update cheque_Book_Request set status=?-(select req_date from cheque_Book_Request where che_account_num=?) where che_account_num=?";                                                                                                                                           
            	ps=con.prepareStatement(query);
            	ps.setDate(1, sqlDate);
            	ps.setString(2, accountnum);
            	ps.setString(3, accountnum);
            	ps.executeQuery();
            }
			else
            {
            	chequeBookRequest(type,userid);
            }
            
			
			
		} else if (type.equalsIgnoreCase("saving")) {

			String query2 = "select CHE_ACCOUNT_NUM  from Cheque_Book_Request where CHE_ACCOUNT_NUM in(select svaccount_num from SAVING_ACCOUNT  where svaccount_num in (select account_num from user_account_num where id=?))";
			con = ConnectionProvider.getConnection();
			ps = con.prepareStatement(query2);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if(rs.next())
            {
            	accountnum=(String)rs.getString(1);
            	 String query="update cheque_Book_Request set status=?-(select req_date from cheque_Book_Request where che_account_num=?) where che_account_num=?";                                                                                                                                           
            	ps=con.prepareStatement(query);
            	ps.setDate(1, sqlDate);
            	ps.setString(2, accountnum);
            	ps.setString(3, accountnum);
            	ps.executeQuery();
            }
			else
            {
            	chequeBookRequest(type,userid);
            }
            
            
			

		
	}
	}
    
}
