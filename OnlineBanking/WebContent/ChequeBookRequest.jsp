<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
</script>
<%if(session!=null)
	{
	System.out.print("cheque:"+session.getAttribute("userid"));
	System.out.print("cheque:"+session.getAttribute("accountype"));
	}%>
<body background="images/1.jpg">
 
<form action="ChequeBookServ" method="Post">
   For Cheque Book Request Click Yes
    <br><br>
    <input type="submit" name="action" value="yes">
    <input type="submit" name="action" value="no">
</form>
</body>
</html>