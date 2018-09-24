<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<title>Insert title here</title>
<style>
* {
    box-sizing: border-box;
    font-family: Arial, Helvetica, sans-serif;
}
.mySlides {display:none;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}
hr { 
    display: block;
    margin-top: 0.5em;
    margin-bottom: 0.5em;
    margin-left: 20px;
    margin-right: 20px;
    border-style: inset;
    border-width: 1px;
} 
/* Style the top navigation bar */
.topnav {
    overflow: hidden;
    background-color:Tomato;
}
/* Centered text */
.centered {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    font-size:400%;
    color:white;
}

/* Style the topnav links */
.topnav a {
    float: left;
    display: block;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
    background-color:aqua;
    color:black ;
}
.topnav-right {
  float: right;
}

/* Style the content */
.content {
    background-color: #ddd;
    padding: 10px;
    height: 200px; /* Should be removed. Only for demonstration */
}
.header {
    color:tomato;
    padding-top:20px;
    margin:30px;
}

.infobox {
    background-color: white;
    width: 1100px;
    border: 10px tomato ;
    /* padding: 25px; */
    margin: 25px;
}

/* Style the footer */
.footer {
    background-color: #f1f1f1;
    padding: 10px;
}
</style>

</head>
<body>
<div class="topnav">

  <a href="index.jsp">Login</a>
  <a href="RegistrationForm.jsp">Register</a>
  <a href="#">About Us</a>
  <div class="topnav-right">
   <h1>Online Banking</h1>
  </div>
</div>

<!-- <div class="content">
  <h2>CSS Template</h2>
  <p>A topnav, content and a footer.</p>
</div> -->
<!-- <h2 class="w3-center">Online Banking</h2> -->

<div class="w3-content w3-display-container">
  <img class="mySlides" src="images/img3.jpg" style="width:100%">
 	<img class="mySlides" src="images/1.jpg" style="width:100%">
 	<img class="mySlides" src="images/2.jpg" style="width:100%">
 	<img class="mySlides" src="images/3.jpg" style="width:100%">
 	<img class="mySlides" src="images/4.jpg" style="width:100%">
			<!-- <div class="centered">Online Banking</div> -->
  <button class="w3-button w3-black w3-display-left" onclick="plusDivs(-1)">&#10094;</button>
  <button class="w3-button w3-black w3-display-right" onclick="plusDivs(1)">&#10095;</button>
</div>

<div class="header"><h2>Internet Banking</h2></div>
<div class="infobox"> <p>Internet Banking is a convenient way to do banking from 
the comfort of your home or office. 
Avoid the queue or delays and try our 
simple and secure Internet Banking facility for an unmatched online 
banking experience.<p></div>
<hr>
<div class="header"><h2>Features Of Internet Banking</h2></div>
<ul>
  <li>Check Account Statement</li>
  <li>Transfer Funds</li>
  <li>Open a Fixed Deposit</li>
   <li>Pay utility bills</li>
    <li>Open Deposits</li>
     <li>Pay Taxes</li>
     <li>And Many more financial and non-financial services</li>
     
</ul>  
<hr>
<div class="header"><h2>Banking at your fingertips</h2></div>
<div class="infobox"> <p>Internet Banking offers you the ease 
and convenience of transacting in an environment you feel most comfortable with. 
You can check balances and transactions, 
transfer funds, pay bills, open fixed and recurring deposits and much more.<p></div>
<hr>
<div class="footer">
  <p>Footer</p>
</div>
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex-1].style.display = "block";  
}
</script>
</body>
</html>