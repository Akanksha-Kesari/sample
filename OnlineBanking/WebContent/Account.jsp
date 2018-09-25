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
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 15px;
}
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}

</style>
</head>

<%


%>
<body background="images/1.jpg">
<div class="topnav">

  <a class="" href=""></a>
  <a href="Welcome.jsp">Home</a>
  <a href="FundTransferLogin.jsp">Fund Transfer</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>





<%session=request.getSession(false);

Object userid=null;
if(session!=null)
{  List<String> i=(List<String>)session.getAttribute("accountlist");
     String  val=(String)request.getParameter("val");
     System.out.print(val);
    /*  System.out.print("account:"+i.get(Integer.parseInt(val.toString()))); */
	userid=session.getAttribute("userid");
	
try{
	UserDAO obj=new UserDAO();
ResultSet rs1 = obj.showAccountDetail(i.get(Integer.parseInt(val.toString())), userid.toString());
while(rs1.next()){
%>
<div style="background-color:lightblue">
<%=rs1.getString(1) %>
<center>

balance&nbsp; &nbsp;<%=rs1.getString(2) %>

</center></div>
<div class="">
						<select id="select" name="select"  onchange="report(this)">
						<option value="select your choice">select your choice</option>
							<option value="ministatement">Mini Statement</option>
							<option value="onemonth">one month </option>
							<option value="threemonth">three month</option>
						</select> <br>
					</div>
<%

}


 }
catch(Exception ex)
{
    out.println(ex);
 }}
else
{
	response.sendRedirect("index.jsp");
	}

%>
<div id="mini_statement" style="display:none;">

<table style="width:100%">
  <tr>
    <th>Date</th>
    <th>Reference number</th> 
    <th>Amount</th>
  </tr>
 <%UserDAO obj1=new UserDAO();
 System.out.print(userid);
 List<String> i=(List<String>)session.getAttribute("accountlist");
 String  val=(String)request.getParameter("val");
  ResultSet rs1=obj1.ministatement(i.get(Integer.parseInt(val.toString())),userid.toString());
  while(rs1.next())
  {%>
  <tr><td><%=rs1.getString(3)%></td><td><%=rs1.getString(2)%></td><td>
 <%=rs1.getString(4) %></td></tr>
       
  <%} %>
</table>

</div>

<div id="one_month" style="display:none;">

<table style="width:100%">
  <tr>
    <th>Date</th>
    <th>Reference number</th> 
    <th>Amount</th>
  </tr>
 <%
 System.out.print(userid);
 
 
 rs1=obj1.onemonth(i.get(Integer.parseInt(val.toString())),userid.toString());
  while(rs1.next())
  {%>
  <tr><td><%=rs1.getString(3)%></td><td><%=rs1.getString(2)%></td><td>
 <%=rs1.getString(4) %></td></tr>
       
  <%} %>
</table>

</div>
<div id="three_month" style="display:none;">

<table style="width:100%">
  <tr>
    <th>Date</th>
    <th>Reference number</th> 
    <th>Amount</th>
  </tr>
 <%
 System.out.print(userid);
  rs1=obj1.threemonth(i.get(Integer.parseInt(val.toString())),userid.toString());
  while(rs1.next())
  {%>
  <tr><td><%=rs1.getString(3)%></td><td><%=rs1.getString(2)%></td><td>
 <%=rs1.getString(4) %></td></tr>
       
  <%} %>
</table>

</div>

<script type="text/javascript">
function report(select)
{
    if(select.value=="ministatement")
    	{document.getElementById('three_month').style.display="none";
    	  document.getElementById('mini_statement').style.display="block";
    	  document.getElementById('one_month').style.display="none";

    	}
    else if(select.value=="onemonth")
	{document.getElementById('three_month').style.display="none";
	  document.getElementById('mini_statement').style.display="none";
	  document.getElementById('one_month').style.display="block";

	}
    else  if(select.value=="threemonth")
	{
    	document.getElementById('three_month').style.display="block";
  	  document.getElementById('mini_statement').style.display="none";
  	  document.getElementById('one_month').style.display="none";


	}
}


</script>
 

</body>
</html>