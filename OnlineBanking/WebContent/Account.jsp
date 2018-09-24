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

<%Object val=request.getParameter("val");
System.out.print(val);
Object userid=request.getParameter("userid");
System.out.print(userid);
%>
<body background="images/1.jpg">
<div class="topnav">

  <a class="" href=""></a>
  <a href="Welcome.jsp">Home</a>
  <a href="FundTransferLogin.jsp">Fund Transfer</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>




<!-- <img src="images/1.jpg" alt="Banking image" style="width:50%"> -->
<% 

try{
	UserDAO obj=new UserDAO();
ResultSet rs1 = obj.showAccountDetail(val.toString(), userid.toString());
while(rs1.next()){
%>
<div style="background-color:lightblue">
<%=rs1.getString(1) %>
<center>

balance&nbsp; &nbsp;<%=rs1.getString(2) %>

</center></div>
<div class="">
						<select name="select"  onchange="report(this.value)">
						<option value="select your choice">select your choice</option>
							<option value="ministatement">Mini Statement</option>
							<option value="onemonth ">one month </option>
							<option value="threemonth">three month</option>
						</select> <br>
					</div>
<%

}
ResultSet rs=obj.showTransaction(val.toString(), userid.toString());

while(rs.next()){
	
	%>
	<div style="background-color:lightpink">
	<b>Transaction Details</b>
<table style="width:100%">
<tr>
     <th>Date</th>
     <th>Reference Number</th>
    <th>Amount</th> 
    </tr>
 <tr><td><%=rs.getString(3)%></td><td><%=rs.getString(2)%></td><td>
 <%=rs.getString(4) %></td></tr>
       

<% 

}
%>
</table></div>

<% }
catch(Exception ex)
{
    out.println(ex);
 }

%>

<script type="text/javascript">
function report(func)
{
    func();
}

function ministatement()
{
    alert('ministatement');
    
    
}

function monthly()
{
    alert('monthly');
}
</script>
 

</body>
</html>