<%@page import="java.util.ArrayList"%>
<%@page import="dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Simple YouTube Menu Effect</title>
		<meta name="description" content="A tutorial on how to recreate the effect of YouTube's little left side menu. The idea is to slide a little menu icon to the right side while revealing some menu item list beneath. " />
		<meta name="keywords" content="Add keywords" />
		<meta name="author" content="_yourName_ for Codrops" />
		<link rel="shortcut icon" href="../favicon.ico"> 
		<link rel="stylesheet" type="text/css" href="css/default1.css" />
		<link rel="stylesheet" type="text/css" href="css/component1.css" />
		<script src="js/modernizr1.custom.js"></script>
</head>


<% 
session= request.getSession(false);
List<String>accountlist=new ArrayList<String>();
 Object userid=null;
				if(session!=null)
				{
					userid=session.getAttribute("userid");
					System.out.print(userid.toString());
			        
			        UserDAO obj=new UserDAO();
			        ResultSet rs=obj.accountype(userid.toString());
			      
			      
			       while(rs.next())
			       {
			    	   accountlist.add(rs.getString(1));
			    	   
			       }
			     session.setAttribute("accountlist", accountlist);
				}
				else
				{
					response.sendRedirect("index.jsp");
				}

        
       %>
<body background="images/1.jpg">

<div class="container">	
			<header class="clearfix">
				<h1>Types Of Accounts </h1>	
			</header>
			<div class="main">
				<div class="side">
					<nav class="dr-menu">
						<div class="dr-trigger"><span class="dr-icon dr-icon-menu"></span><a class="dr-label">Account</a></div>
						<ul>
							<%userid=session.getAttribute("userid");
							for(int i=0;i<accountlist.size();i++)
					       {%>
					       <li><a class="dr-icon " href="Account.jsp?val=<%=i %>"><%=accountlist.get(i) %></a></li>
					       <%} %>
					       <li><a href="index.jsp">Logout</a>
							</ul>
					</nav>
				</div>
			</div>
		</div><!-- /container -->
		<script src="js/ytmenu1.js"></script>
	
</body>
</html>