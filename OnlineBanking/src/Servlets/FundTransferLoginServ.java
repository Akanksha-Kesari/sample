package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
public class FundTransferLoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public FundTransferLoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountnum =(String)request.getParameter("accountnum");
		String password=(String)request.getParameter("Password");
		UserDAO obj=new UserDAO();
		try {
			if(obj.validateTransactionPassword(accountnum, password))
			{
                 
				request.setAttribute("accountnum", accountnum);
				
				RequestDispatcher rs= request.getRequestDispatcher("FundTransfer.jsp");
				rs.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
