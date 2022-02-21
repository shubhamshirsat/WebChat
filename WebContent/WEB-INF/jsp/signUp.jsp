<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">

<title>Insert title here</title>
<script type="text/javascript">
   
  	 	function confirmPassword()
  	 	{
 
        	var pass = document.getElementById("password").value
        	var len = pass.length;
 
        	var confPass = document.getElementById("confirm_password").value
        	
        	if(len < 8)
 			{
        		      alert('Password should contain minimum 8 characters'); 
        		      return false;
        		
 			}
        	else if(pass != confPass)
    	    {
        	   		 alert('Wrong confirm password !');
        	    	 return false;
        	}
       		
        	return true;
    	}
</script>

</head>
<body><br><br><br><br><br><br><br><br>
	<table align="center">
	<tr>
	<td>
	<form id="signUpForm" onsubmit="return(confirmPassword());" action="signUp" method="post">
	      <span id="reauth-email" class="reauth-email"></span>
	
	       <input type="text" name="firstname" id="firstname" class="textbox" placeholder="First Name" required><br><br>
	       <input type="text" name="lastname" id="lastname" class="textbox" placeholder="Last Name" required><br><br>
	       <input type="email" name="email" id="email" class="textbox" placeholder="Email id" required><br><br>
    	   <input type="password" name="password" id="password" class="textbox" placeholder="Password" required><br><br>
		   <input type="password" id="confirm_password" class="textbox" placeholder="Confirm Password" required><br><br>
		       
	       <input class="button button1" type="submit" value="Sign up">

	</form>
	</td>
	</tr>
	</form>
	<table>
</body>
</html>