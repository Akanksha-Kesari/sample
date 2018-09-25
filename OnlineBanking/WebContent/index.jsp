<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content="Classic Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements"
	/>
	<script>
		/* addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);

		function hideURLbar() {
			window.scrollTo(0, 1);
		} */
		/* var inc=0;
		 function myFunction() {
		    inc=inc+1;
		    alert(inc);    
		 } */
	</script>
	<!-- Meta tag Keywords -->
	<!-- css files -->
	<link rel="stylesheet" href="css/style1.css" type="text/css" media="all" />
	<!-- Style-CSS -->
	<link rel="stylesheet" href="css/font-awesome1.css">
	<!-- Font-Awesome-Icons-CSS -->
	<!-- //css files -->
	<!-- web-fonts -->
	<link href="//fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
	<!-- //web-fonts -->
	</head>
<body background="images/1.jpg">
<h1>

		<span>L</span>ogin <span>H</span>ere
		</h1>
	<!--//header-->
	<!-- content -->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="LoginServ" method="post">
				<div class="form-style-agile">
					<label>User Id</label>
					<div class="pom-agile">
						<input placeholder="User Id" name="userid" type="text" required="">
					</div>
				</div>
					<div class="form-style-agile">
					<label>Password</label>
					<div class="pom-agile">
						<input placeholder="Password" name="Password" type="password" id="password" required="">
						
					</div>
				</div>
				
						<div class="clear"></div>
						<%
						String msg=(String)request.getAttribute("msg");
						if(msg==null){ %>
				<input type="submit" onclick="myFunction()" value="Login">
				<%} 
				else
				{%>
				<script>
					alert("account locked");
					</script>
			<%	}%>
				<div class="form-style-agile">
					
					<br>New User?	
					<a href="RegistrationForm.jsp"> Register here</a>	
					</div>
				<div class="form-style-agile">
					
					<br>Forgot Password?	
					<a href="ForgetPassword.jsp"> Click here</a>	
					</div>
				
				
				
			</form>
		</div>
	</div>
	
		
</body>
</html>