<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<%Object accountnum=request.getAttribute("accountnum") ;%>
<body background="images/1.jpg">
	<h1>
		<span>T</span>hird <span>P</span>arty <span>T</span>ransaction
	</h1>
	<!--//header-->
	<!-- content -->
	<div class="main-content-agile">
		<div class="sub-main-w3">
			<form action="FundTransferServ?value=<%=accountnum %>" method="post">
				<div class="form-style-agile">
					<label>From Account</label>
					<div class="pom-agile">
						<input placeholder=<%=accountnum %> name="accountnum1"   disabled="disabled">
					</div>
				</div>
				<div class="form-style-agile">
					<label>To Account</label>
					<div class="pom-agile">
						<input placeholder="Receiver Account Number" name="accountnum2"
							type="text" required="">
					</div>
				</div>
				<div class="form-style-agile">
					<label>Amount</label>
					<div class="pom-agile">
						<input placeholder="Enter Amount" name="amount"
							type="text" required="">
					</div>
				</div>










				<div class="clear"></div>
				<input type="submit" value="Transfer">
			</form>
		</div>
	</div>
	<!-- //content -->



</body>
</html>