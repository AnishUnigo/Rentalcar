<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.lang.String" %>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>RentalCars</title>
	<meta name="description" content="">

	<meta name="author" content="Web Domus Italia">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/slider.css">
	<link rel="stylesheet" type="text/css" href="style/mystyle.css">
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="register.css">
		<script type="text/javascript" src="register.js"></script>
	 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	 <link rel="stylesheet" href="style/style.css">
	 
</head>
<body style="background-image: url(image/cars.png); height:100%; width:100%" class="body">
<!-- Header -->
<div class="allcontain" id="allcontainId">
	<div class="header">
			<ul class="socialicon">
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
			</ul>
			<ul class="givusacall">
				<li>  </li>
			</ul>	
			
			<ul class="logreg" align="right">
				<li><a href="#" style="height: 100px; font-size: 150%" id="loginform">Login </a> </li> <script src="js/loginindex.js"></script>
				<li><a onclick="document.getElementById('id01').style.display='block'" style="width:auto;"><span style="height: 100px; font-size: 150%"class="register">Register</span></a></li>
			</ul>
	</div>
	<!-- Navbar Up -->
	<nav class="topnavbar navbar-default topnav">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed toggle-costume" data-toggle="collapse" data-target="#upmenu" aria-expanded="false">
					<span class="sr-only"> Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand logo" href="#"><img src="image/rentacar1.png" alt="logo"></a>
			</div>	 
		</div>
		<div class="collapse navbar-collapse" id="upmenu">
			<ul class="nav navbar-nav" id="navbarontop">
				<li class="active" ><a href="#" >HOME</a> </li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"	data-toggle="dropdown" style="color:white" role="button" aria-haspopup="true" aria-expanded="false">CATEGORIES <span class="caret"></span></a>
					<ul class="dropdown-menu dropdowncostume">
						<li><a href="#">Sport</a></li>
						<li><a href="#">Old</a></li>
						<li><a href="#">New</a></li>
					</ul>
				</li>
				<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="color:white" role="button" aria-haspopup="true" aria-expanded="false">DEALERS <span class="caret"></span></a>
						<ul class="dropdown-menu dropdowncostume">
							<li><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="3">3</a></li>
						</ul>
				</li>
				<li>
					<a href="contact.html" style="color:white">CONTACT</a>
 
				</li>
				<li>
					
					<a style="color:white" href="manageSchedule.jsp">My schedule</a> 
				
			</ul>
		</div>
	</nav>

	
</div>

<style>
		.header{
		height:20%; 
		width:100%; 
		float:left;
		border: solid black;
	}
	.searchbox{
		position: absolute;
		left: 65%;
		top: 25%;
		
		width:30%; 
		
		border-radius:18px;
		background-color :#0b0ba0;
		opacity: 0.9;
		filter: alpha(opacity=20);
	}
	.h1search{
		position: relative;
		top: -15%;
		left: 22%;
	}
	 table{
		position : relative;
		top: -5%;
		left: 5%;
		
	 }
	 .locationBox{
		position: relative;
		top: -15%;
		left: 15%;
	 }
	 input[type=text] {
    width: 70%;
    padding: 8px 8px;
    margin: 8px 0;
    display: block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
	}
	input[type=date] {
    width: 70%;
    padding: 10px 2px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
	}
	input[type=time] {
	position: relative;
	left: -10%;
    width: 80%;
    padding: 10px 12px;
    margin: 8px 0;
    display: block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
	}
	input[type=submit] {
	position: relative;
	left : 32%;
    width: 32%;
    background-color: #4CAF50;
    color: white;
    padding: 15px 18px;
    margin: 1px 0;
    border: none;
    border-radius: 10px;
    cursor: pointer;
}
	.ajaxresponsefield{
	color: red;
		
	}
	
</style>
<script>
	var data=[{"city":"irving","state":"tx","zipcode":65012},
				{"city":"dallas","state":"tx","zipcode":65525},
				{"city":"huston","state":"tx","zipcode":56023},
				{"city":"austin","state":"tx","zipcode":68215},
				{"city":"queens","state":"ny","zipcode":11368},
				{"city":"brooklyn","state":"ny","zipcode":11524},
				{"city":"bronz","state":"ny","zipcode":11526},
				{"city":"manhattan","state":"ny","zipcode":56425}
	];
	function listLocations(){
		var xmlHttp= GetXmlHttpObject();
		var location=document.getElementById("loc");
		var locationlist=document.getElementById
	var listout=""+data[0].city+" ,";
	listout+=data[0].state+" ,";
	listout+=data[0].zipcode+"\n";
	listout+=data[1].city+" ,";
	listout+=data[1].state+" ,";
	listout+=data[1].zipcode+" \n";
	console.log(listout);
		if(loc=="ir"){
			
		}
	}
	
	function loadDoc(){
		xmlHttp= GetXmlHttpObject();
		var location=document.getElementById("loc").value;
		var url="searchLocation";
	
		xmlHttp.open("POST",url,true);
		xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
		xmlHttp.send("location"+location);
		xmlHttp.onreadystatechange  = function (){
			if (xmlHttp.readyState == 4) {
				 if(xmlHttp.status == 200) {
				  var response= xmlHttp.responseText; 
				 	console.log(":"+response+":");
				 	
				  if(response=="error") {
					  console.log("printing error");
						document.getElementById("ajaxresponsefield").innerHTML="please enter location";
						document.getElementById("ajaxresponsefield").style.color="red";
				 	} else{
				 		document.getElementById("ajaxresponsefield").innerHTML="";
				 	} 	 
				}
				 else {  alert("ajax call failed");}}
			
		};
	}
		function GetXmlHttpObject()
		{ 
			var xmlHttp=null;
		try { 
		  xmlHttp=new XMLHttpRequest(); }
		catch (e)
		 { 
		  try{  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");    }
		  catch (e) {  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");    }
		 } return xmlHttp;
		}
		
		function onSubmit(){
			
			var location=document.getElementById("loc").value;
			var pickupD=document.getElementById("pickup").value;
			var pickupT=document.getElementById("ptime").value;
			var returnD=document.getElementById("return").value;
			var returnT=document.getElementById("rtime").value;
			
			
		}
		function onFocusOut(){
			var xmlHttp = GetXmlHttpObject();
			var loginemail=document.getElementById("loginemailid").value;
			var url="register";
			
			xmlHttp.open("POST",url,true);
			xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
			xmlHttp.send("loginemail="+loginemail);
			
			xmlHttp.onreadystatechange  = function (){
				if (xmlHttp.readyState == 4) {
					 if(xmlHttp.status == 200) {
					  var response= xmlHttp.responseText; 
					 	console.log(":"+response+":");
						if(loginemail==""){
							document.getElementById("emaillabel").innerHTML="Email Id is must";
							document.getElementById("emaillabel").style.color="red";
							document.getElementById("emailid").style.border="solid red";
						}else if(response=="failed"){
							console.log("response : "+response);
							document.getElementById("emaillabel").innerHTML="Email Id not found";
							document.getElementById("emaillabel").style.color="red";
							document.getElementById("emailid").style.border=" solid red";
						} 	 else{
							document.getElementById("emaillabel").innerHTML="";
							document.getElementById("emailid").style.border="";
						}
					}
					 else {  alert("ajax call failed");}}
				
			};
		}
		 function onLoginButton(){
			 var xmlHttp= GetXmlHttpObject();
			 var loginEmailBtn=document.getElementById("emailid").value;
			 var pswdBtn=document.getElementById("passid").value;
			 var url="register";
			 
			 xmlHttp.open("POST",url,true);
				xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
				xmlHttp.send("pswdBtn="+pswdBtn);
				
				xmlHttp.onreadystatechange  = function (){
					if (xmlHttp.readyState == 4) {
						 if(xmlHttp.status == 200) {
						  var response= xmlHttp.responseText; 
						 	console.log(":"+response+":");
						 	
						 	var jsonRes=JSON.parse(response);
						 	console.log(typeof jsonRes);
						 		
							if(pswdBtn==""){
								document.getElementById("passwordlabel").innerHTML="Password please";
								document.getElementById("passwordlabel").style.color="red";
								document.getElementById("passid").style.border="solid red";
							}else if(jsonRes.password_check=="not_exists"){
								console.log("response : "+jsonRes.password_check);
								document.getElementById("passwordlabel").innerHTML="email or password incorrect";
								document.getElementById("emailid").style.border=" solid red";
								document.getElementById("passid").style.border=" solid red";
							} 	 else{
								document.getElementById("passwordlabel").innerHTML="";
								document.getElementById("passid").style.border="";
								document.getElementById("emailid").style.border="";
							}
						}
						 else {  alert("ajax call failed");}}
					
				};
		 }
</script>

<form action="selectCars" method="POST" style="width: 100%">
	<div id="searchid" class="searchbox" style="float:left">
		<h1 class="h1search" style="color:white">Book a Car</h1>
		<div class="locationBox">
			<input type="text"  name="locations" id="loc" placeholder="search for Locations" list="locationlist" onkeyup="listLocations()">
			<datalist id="locationlist">
			</datalist></br>
			<span id="ajaxresponsefield"></span>
		</div>
		<table>
			<tr>
				<td>
					<label style="color:white">Pick-Up Date</label>
					<input type="date" name="pickdateI" id="pickup" min="<%=new Date()%>" required/>
				</td>
				<td>
					<label style="color:white">Time</label></br>
					<input type="time" name="picktime" id="ptime"/>
				</td>
			</tr>
			<tr><label></label></tr>
			<tr>
				<td>
					<label style="color:white">Return date</label>
					<input type="date" name="returndateI" id="return" min="<%=new Date() %>" required/>
				</td>
				<td>
					<label style="color:white">Time</label></br>
					<input type="time" name="returntime" id="rtime"/>
				</td>
			</tr>
		</table>
			<input type="submit" id="sbmt" value="Search">search</input>
	</div>
</form>

<!--register-->

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="action_page.php">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
    </div>

    <div class="container">
      <input type="text" name="firstName" id="fname" placeholder="First Name"> &nbsp;<input type="text" name="lastName" id="lname" placeholder="Last Name" onblur="names()"> </br>
		<span id="ajaxcall"></span></br>
		<input type="text" name="userid" id="uid" placeholder="user id"> &nbsp;</br>
		Email : <input type="email" name="email" id="emailid" onblur="onEmail()"><span id="emailajax"></span></br>
		DOB : <input type="date" name="date" id="dateid" > </br>
		male : <input type="radio" name="sex" value="male">&nbsp; Female :<input type="radio" name="sex" value="female"></br>
		<input type="text" name="mobile" id="mobileid" placeholder="mobile Number"></br>
		password : <input type="password" name="password" id="pwd" onblur="onPassword()">
		<span id="pwdspan"></span><br>
		Retype-password : <input type="password" name="retype" id="repwd"></br>
		<input type="submit" name="submit" id="sbmt">
    </div>

    
    </div>
  </form>
</div>

<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>



	<div id="logindisplay" class="login">
    	<div class="arrow-up"></div>
      		<div class="formholder">
       			 <div class="randompad">
          		 <fieldset>
          		<form action="register" method="post">
            	 <label name="email">Email</label>
             	<input type="email"  name="email" id="loginemailid" placeholder="example@example.com" onblur="onFocusOut()" required/>
            	<label id="emaillabel"></label><br/>
            	 <label name="password">Password</label>
             	<input type="password" name="loginpswd" placeholder="******" id="passid" required/>
             	<%-- <% String incorrect=(String) request.getAttribute("incorrect"); %>
             	<% if(incorrect!=null && incorrect!=""){%>
             	<label id="passwordlabel" style="color:red"><%=incorrect%></label><br/>
             	<% }else {%>
             	<label id="passwordlabel" style="color:red"></label><br/>
             	<% }%> --%>
             	
            	 <input type="submit" value="Login" id="loginbutton" onClick="onLoginButton()"/>
 			  	<form> 
           		</fieldset>
        	</div>
      	</div>
  	</div>

<!--footer div-->
<!--			<div class="footer">
				<div class="copyright">
				  &copy; Copy right 2016 | <a href="#">Privacy </a>| <a href="#">Policy</a>
				</div>
				<div class="atisda">
					 Designed by <a href="http://www.webdomus.net/">Web Domus Italia - Web Agency </a> 
				</div>
			</div>
-->
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.js"></script>
<script type="text/javascript" src="source/js/isotope.js"></script>
<script type="text/javascript" src="source/js/myscript.js"></script> 
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/jquery.1.11.js"></script>
<script type="text/javascript" src="source/bootstrap-3.3.6-dist/js/bootstrap.js"></script>
</body>
</html>