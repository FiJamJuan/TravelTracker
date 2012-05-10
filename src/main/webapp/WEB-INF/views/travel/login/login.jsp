<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Travel Tracker</title>
</head>
<link rel="stylesheet" href="../../style/style.css" />
</head><body onload='document.f.j_username.focus();'>
<div class="OuterFrame">
<div class="TopBanner">
<h1>Travel Tracker</h1>
</div> <!--end TopBanner-->
<div class="Register">
 <br />

<div class="warning">
${error}<br/></div>
<div class="normal">

Login with Username and Password<form name='f' action='../../j_spring_security_check' method='POST'>

<br />

    User: <input type='text' name='j_username' value=''><br />
    Password:<input type='password' name='j_password'/><br />
    <br/><center><input name="submit" type="submit" value="login"/></center></form><br />	
    <form method="get"><input type="hidden" name="home" value="home"><input type="submit" value="HOME"></form>


  

 

</div>   <!--end Normal-->

</div> <!--end Register-->

</div> <!--end OuterFrame-->

</body>
</html>