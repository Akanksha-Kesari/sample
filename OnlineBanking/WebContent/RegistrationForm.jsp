<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords"
	content="Classic Register Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link rel="stylesheet" href="css/style1.css" type="text/css" media="all" />
<!-- Style-CSS -->
<link rel="stylesheet" href="css/font-awesome1.css">
<!-- Font-Awesome-Icons-CSS -->
<!-- //css files -->
<!-- web-fonts -->
<link
	href="//fonts.googleapis.com/css?family=Oswald:200,300,400,500,600,700"
	rel="stylesheet">
<link
	href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
	rel="stylesheet">
<!-- //web-fonts -->
</head>
<body background="images/1.jpg">
	<h1>

		<span>R</span>egister <span>H</span>ere
	</h1>
	<!--//header-->
	<!-- content -->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="RegistrationSer" method="post">
				<div class="form-style-agile">
					<label>First Name</label>
					<div class="pom-agile">
						<input placeholder="First Name" name="fname" type="text"
							required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Last Name</label>
					<div class="pom-agile">
						<input placeholder="Last Name" name="lname" type="text"
							required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Address</label>
					<div class="pom-agile">
						<input placeholder="Address" name="address" type="text"
							required="">
					</div>
				</div>
				
				<div class="form-style-agile">
					<label>User Id</label>
					<div class="pom-agile">
						<input placeholder="User Id" name="uid" type="text" required="">

					</div>
				</div>

				<div class="form-style-agile">
					<label>Select Question</label>
					<div class="pom-agile">
						<select name="que" class="pom-agile">
							<option value="What is your pet name?">What is your pet name?</option>
							<option value="What are the last 3 digits of your mobile number?">What are the last 3 digits of your
								mobile number?</option>
							<option value="Which is your favourite sport?">Which is your favourite sport?</option>
						</select> <br>
					</div>
				</div>

				<div class="form-style-agile">
					<label>Answer</label>
					<div class="pom-agile">
						<input placeholder="Answer" name="answer" type="text" required="">

					</div>
				</div>

				<div class="form-style-agile">
					<label>Password</label>
					<div class="pom-agile">
						<input placeholder="Password" name="Password" type="password"
							id="password1" required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Confirm Password</label>
					<div class="pom-agile">
						<input placeholder="Confirm Password" name="Confirm Password"
							type="password" id="password2" required="">
					</div>
				</div>


					<div class="clear"></div>
				<input type="submit" value="Register">
			</form>
		</div>
	</div>
	<!-- //content -->


	<!-- password-script -->
	<script>
		window.onload = function() {
			document.getElementById("password1").onchange = validatePassword;
			document.getElementById("password2").onchange = validatePassword;
		}

		function validatePassword() {
			var pass2 = document.getElementById("password2").value;
			var pass1 = document.getElementById("password1").value;
			if (pass1 != pass2)
				document.getElementById("password2").setCustomValidity(
						"Passwords Don't Match");
			else
				document.getElementById("password2").setCustomValidity('');
			//empty string means no validation error
		}
	</script>
	<!-- //password-script -->
</body>
</html>