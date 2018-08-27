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
	 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	 <link rel="stylesheet" href="style/style.css">
<style>
	input[type=submit] {
	position: relative;
	left : 40%;
    width: 15%;
    background-color: #4CAF50;
    color: white;
    padding: 10px 15px;
    margin: 1px 0;
    border: none;
    border-radius: 10px;
    cursor: pointer;
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
	strong,span{
		color: white;
	}
	.manage{
		position : relative;
		right : 35%;
		top : 30%;
			
	}

</style>	
 
</head>
<body style="height:100%; width:100%" class="body">
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
				<li style="font-size: 150%" >
					<span id="usernamelist"></span>
				 </li>
			</ul>	
			<ul class="logreg" align="right">
				<input type="hidden" value="" id="logoutuser">
				<li><a href="#" style="height: 100px; font-size: 150%" id="loginform" value="" onClick="userLogout()">Logout </a> </li> 
				
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
			</ul>
		</div>
	</nav>
</div>
<div class="manageschedule"> 
<form action="displayByName" method="get">
	<input type="text" id="rc" name="byname" placeholder="Enter name by search">
	<input type="submit">
	</form>
</div>

<!-- 
<div> 
	<% String carname=(String)request.getAttribute("carname"); %>
	<% String cartype=(String)request.getAttribute("cartype"); %>
	<%-- <% int carprice=(Integer)request.getAttribute("carprice"); %> --%>
	<% Date pickupdate=(Date)request.getAttribute("pickupdate"); %>
	<% Date returndate=(Date)request.getAttribute("returndate"); %>
	<% if(carname!=null){%>
	<span>you have booked  </span><strong><%=carname %></strong></br>
	<span>your car type is </span><strong><%=cartype %></strong></br>
	<span> please come and pick up at </span><strong><%=pickupdate %></strong></br>
	<span> and return the car on </span><strong><%=returndate %></strong></br>
	<%-- <span>carprice : </span><strong><%=carprice %></strong></br> --%>
	<%} %>
	<%if (carname!=null){ %>
		<table color = "white" border="3">
			<tr>
				<th><font color="white">car name</font></th>
				<th><font color="white">car type</font></th>
				<th> <font color="white">pickup Date</font> </th>
				<th><font color="white"> return Date</font> </th>
			</tr>
			<tr>
				<td><font color="white"><%=carname%></font></td>
				<td><font color="white"><%=cartype %></font></td>
				<td><font color="white"> <%=pickupdate %> </font></td>
				<td> <font color="white"><%=returndate %> </font></td>  
			</tr>
		</table>
	<%} %>
</div>
-->

