 package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

public class FundTransferServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FundTransferServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountnum1 =(String)request.getParameter("value");
		System.out.println(accountnum1);
		String accountnum2 =(String)request.getParameter("accountnum2");
		String amount=(String)request.getParameter("amount");
		UserDAO obj=new UserDAO();
		try {
			if(obj.validateReceiverAccountNumber(accountnum2))
			{
                 obj.fundTransfer(accountnum1, accountnum2, amount);
                 obj.deposit(accountnum2, amount);
                 obj.withdrawl(accountnum1, amount);
				request.setAttribute("amount", amount);
				RequestDispatcher rs= request.getRequestDispatcher("Transfered.jsp");
				rs.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
