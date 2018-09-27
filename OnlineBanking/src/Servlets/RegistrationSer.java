package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * Servlet implementation class RegistrationSer
 */
public class RegistrationSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationSer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String fname = (String)request.getParameter("fname");
        String lname = (String)request.getParameter("lname");
        String address = (String)request.getParameter("address");
       
        String userId = (String)request.getParameter("uid");
        String que = (String)request.getParameter("que");
        String answer = (String)request.getParameter("answer");
        String password = (String)request.getParameter("Password");
        String confirmP = (String)request.getParameter("Confirm Password");
         User u=new User(fname,lname,address,userId,que,answer,password,confirmP);
         UserDAO obj=new UserDAO();
        
         try {
			if(obj.validateAccountNumber(u))
			  {
				
				obj.insertUser(u);
				response.sendRedirect("index.jsp");
				
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	          }

}
