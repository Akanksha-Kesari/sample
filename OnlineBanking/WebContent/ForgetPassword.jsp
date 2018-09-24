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
<body>
<h1>

		<span>A</span>ccount <span>R</span>ecovery
		</h1>

	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="ForgetPasswordServ" method="post">
			<div class="form-style-agile">
					<label>User id</label>
					<div class="pom-agile">
						<input placeholder="User id" name="userid" type="text"
							required="">
					</div>
				</div>
			<div class="">
					<label>Select Question</label>
					<div class="pom-agile">
						<select name="que">
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

				<div class="clear"></div>
				<input type="submit" value="Submit">
			</form>
		</div>
	</div>
</body>
</html>