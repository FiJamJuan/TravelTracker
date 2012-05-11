<%@ page import="ie.cit.cloudapp.UserInfo"%>
<%@ page import="ie.cit.cloudapp.Trip"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../style/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Tracker</title>
<body>
<div class="OuterFrame">
<div class="TopBanner">
<h1>Travel Tracker</h1>
</div> <!--end TopBanner-->

<div class="Body">
<div class="LeftPage">
	<h2>Login</h2><br/>
<div class="login">If you are an existing user please <u>Login</u> here:</div><br/>
<form method="post">
		<input name="userlogin" value="Proceed to Login" type="submit">
		</form>
		
		</div><!--end LeftPage-->
	<div class="RightPage">	

	<h2>Register</h2><br/>
<div class="login">If you are a new user please <u>Register</u> here:</div><br/>
  <form method="post" >
    	<input name="select" value="register" type="hidden">
	<input name="registeruser" value="Proceed to Register" type="submit">
	</form>
	
</div> <!--end RightPage-->
</div> <!--end Body-->
<div class="DescriptionBanner">
<h2>Application Description</h2>
<div class="normal">This is a simple tool that can be used to record trips between different countries and calculate days spent at the destination country.
<br/> This data can then be leveraged for various purposes to track days spent outside your home country.<br/>
To get started all you need to do is register. Then you can login and enter your trip details to start tracking them.<br/>
</div>
</div> <!--end DescrptionBanner-->
</div> <!-- end OuterFrame -->
</body>
</html>



