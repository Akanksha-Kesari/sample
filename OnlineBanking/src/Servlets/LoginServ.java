package Servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;

/**
 * Servlet implementation class LoginServ
 */

public class LoginServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=(String)request.getParameter("userid");
		System.out.println(userid);
		String password=(String)request.getParameter("Password");
		UserDAO obj=new UserDAO();
		try {
			ResultSet rs=obj.selectCountLogin(userid);
			rs.next();
			
			if(rs.getInt(1)<3)
			{
				
			if(obj.validateUser(userid, password))
			{
                HttpSession session=request.getSession(true);
                session.setAttribute("userid", userid);
                session.setMaxInactiveInterval(60*1);
				obj.setCountLoginZero(userid);
				response.sendRedirect("AccountType.jsp");
			}
			else
			{
				response.sendRedirect("index.jsp");
				obj.increment(userid);
			}
			}
			else
			{
				request.setAttribute("msg", "invalid");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
