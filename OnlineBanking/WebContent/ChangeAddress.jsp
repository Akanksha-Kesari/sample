<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords" content=""	/>
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
<body>
<h1>

		<span>C</span>hange <span>A</span>ddress
		</h1>
	<!--//header-->
	<!-- content -->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="AddressServ" method="post">
				<div class="form-style-agile">
					<label>New Address</label>
					<div class="pom-agile">
						<input placeholder="New Address" name="newaddress" type="text" required="">
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