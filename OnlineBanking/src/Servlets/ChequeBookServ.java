package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class ChequeBookServ
 */
public class ChequeBookServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChequeBookServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ans=request.getParameter("action");
		if(ans.equalsIgnoreCase("yes"))
		{
		HttpSession session=request.getSession(false);
		String userid=(String)session.getAttribute("userid");
		String type=(String)session.getAttribute("accountype");
		System.out.println("cheque"+type);
		UserDAO obj=new UserDAO();
		try {
			obj.selectchequeBookRequest(type, userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			response.sendRedirect("AccountType.jsp");
		}
	}

}
