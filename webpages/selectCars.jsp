<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.lang.String" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    
 <html>
<head>
<meta charset="UTF-8">
	<title>RentalCars</title>
	<meta name="description" content="">

	<meta name="author" content="Web Domus Italia">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript" src="js/logoutForm.js"></script>
	<script type="text/javascript" src="js/manageSchedule.js"></script>
	<link rel="stylesheet" type="text/css" href="source/bootstrap-3.3.6-dist/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="source/font-awesome-4.5.0/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="style/slider.css">
	<link rel="stylesheet" type="text/css" href="style/mystyle.css">
	<link rel="shortcut icon" type="image/x-icon" href="favicon.ico" />
	 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	 <link rel="stylesheet" href="style/style.css">
<style>
div.img {
    margin: 5px;
    border: 1px solid #ccc;
    float: left;
    width: 50%;
	
}

div.img:hover {
    border: 1px solid #777;
}

div.img img {
	float:left;
    width: 20%;
    height: 100%;
}

div.desc {
	    padding: 2px;
  
}

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
.topright{
	position: absolute;
	right:0;	
}
.dates{
	color: black;
}
.displaySchedule{
	float : right ;
	width : 50%;
	height : 20%;	
}
</style>
</head>
<body style="color:white">
<% String user=(String) request.getAttribute("username"); %> 

<div class="allcontain" id="allcontainId">
	<div class="header">
			<ul class="socialicon">
				<li><a href="#"><i class="fa fa-facebook"></i></a></li>
				<li><a href="#"><i class="fa fa-twitter"></i></a></li>
				<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
				<li><a href="#"><i class="fa fa-pinterest"></i></a></li>
			</ul>
			<ul class="givusacall">
				<li style="font-size: 150%">
					<% if(user!=null) {%>
					Hello <%=user %>
					
					<%} %>
				 </li>
			</ul>	
			<% if(user!=null) {%>
			<ul class="logreg" align="right">
				<input type="hidden" value="<%=user%>" id="logoutuser">
				<li><a href="#" style="height: 100px; font-size: 150%" id="loginform" value="<%=user%>"onClick="userLogout()">Logout </a> </li> 
				
			</ul>
			<%} %>
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
					<a href="#" style="color:white">CONTACT</a>
				</li>
				<li>
					<input type="hidden" value="<%=user%>" id="manageuser" />
					<a style="color:white" onClick="mySchedule()">My schedule</a> 
					<!-- <a style="color:white" class="dropdown-toggle" data-toggle="dropdown" style="color:white" role="button" aria-haspopup="true" aria-expanded="false">My schedule</a> -->
	</nav>

	
</div>
		<% String location=(String)request.getAttribute("location");%>
		<% String indexPickupDate=(String)request.getAttribute("indexPickupDate");%>
		<% String indexReturnDate=(String)request.getAttribute("indexReturnDate");%>
		<% String picktime=(String)request.getAttribute("picktime");%>
		<% String returntime=(String)request.getAttribute("returntime");%>

<div></div>

<div>
	<form action="selectCars" method="post">
		<div class="img" >
		  <a  href="">
			<img src="image/ford.jpg" alt="Fjords" width="300" height="200">
		  </a>
		  <input type="hidden" value=<%=user %> name="username" ></input>
			<label id="nissanlabel" value="ford" name="carname" >Ford</label> </br>
			<input type="hidden" value="ford" name="carname" ></input>
			
			<label id="fordfulelabel" value="economic" name="cartype" >Type : Economic </label></br>
			<input type="hidden" value="economic" name="cartype" />
			
			<label id="fordlabel" value="petrol" name="fueltype" >Fuel Type : petrol</label></br>
			<input type="hidden" value="petrol" name="fueltype" ></input>
			
			 <% if(location!=null && location!=""){ %>
				Location : <strong><%=location %></strong></br>
				<input type="hidden" value=<%=location %> name="location" ></input>
			<%} %> 
			<% if(indexPickupDate!=null && indexReturnDate!=null) {%>
				pickupdate : <%=indexPickupDate %></br>
				<input type="hidden" name="indexPickupDate" value="<%=indexPickupDate%>" />
				returndate : <%=indexReturnDate %></br>
				<input type="hidden" name="indexReturnDate" value="<%=indexReturnDate %>" />
			<%} else{%>
			<div class="toprigh">
				pickupdate :<input type="date"  name="pickupdate" class="dates" required />
				returndate :<input type="date" name="returndate" class="dates"required/>
			</div>
			<%} %>
		 <div class="desc">
					
				Price :
				<strong name="15"> US $15/Day</strong>
				<input type="hidden" value=15 name="carprice" />
				
			<input type="submit" value="select Car" id="fordButton"></input>
		 </div>
		</div>
	</form>	
	<form action="selectCars" method="post">
		<div class="img">
		  <a target="_blank" href="#">
			<img src="image/nissan.jpg" alt="nissan" width="300" height="200">
		  </a>
		 	<input type="hidden" value="<%=user%>" name="username" />
			<label id="nissanlabel" value="nissan" name="carname" >Nissan</label> </br>
			<input type="hidden" value="nissan" name="carname" />
			
			<label id="fordfulelabel" value="economic" name="cartype" >Type : Economic </label></br>
			<input type="hidden" value="petrol" name="cartype" />
			
			<label id="fordlabel" value="petrol" name="fueltype" >Fuel Type : petrol</label></br>
			<input type="hidden" value="petrol" name="fueltype" />
			 <% if(location!=null && location!=""){ %>
				Location : <strong><%=location %></strong></br>
				<input type="hidden" name="location" value=<%=location %>/>
			<%} %> 
			<% if(indexPickupDate!=null && indexReturnDate!=null) {%>
				pickupdate : <%=indexPickupDate %></br>
				<input type="hidden" name="indexPickupDate" value="<%=indexPickupDate%>"/>
				returndate : <%=indexReturnDate %></br>
				<input type="hidden" name="indexReturnDate" value="<%=indexReturnDate %>"/>
			<%} else{%>
			<div class="toprigh">
				pickupdate :<input type="date"  name="pickupdate" required />
				returndate :<input type="date" name="returndate" required/>
			</div>
			<%} %>
		<div class="desc">
			Price :
			<strong> US $15/Day</strong>
			<input type="hidden" value=15 name="carprice" />
			
			<input type="submit" value="select Car" id="nissanButton"></input>
		 </div>
		</div>
		</form>
	<form action="selectCars" method="post">
		<div class="img">
		  <a target="_blank" href="#">
			<img src="image/toyota.jpg" alt="Toyota" width="300" height="200">
		  </a>
		  <input type="hidden" value="<%=user %>" name="username" />
		  <label id="toyotalabel" value="toyota" name="carname" >Toyota</label></br>
		  <input type="hidden" value="toyota" name="carname" />
			<label id="fordlabel" value="economic" name="economic" >Type : Economic </label></br>
			<input type="hidden" value="economic" name="cartype" />
			
			<label id="fordfulelabel" value="diesel" name="fuel" >Fuel Type : Diesel</label></br>
			<input type="hidden" value="diesel" name="fueltype" />
			 <% if(location!=null && location!=""){ %>
				Location : <strong><%=location %></strong></br>
				<input type="hidden" name="location" value="<%=location %>"/>
			<%} %> 
			<% if(indexPickupDate!=null && indexReturnDate!=null) {%>
				pickupdate : <%=indexPickupDate %></br>
				<input type="hidden" name="indexPickupDate" value=<%=indexPickupDate%>/>
				returndate : <%=indexReturnDate %></br>
				<input type="hidden" name="indexReturnDate" value=<%=indexReturnDate %>/>
			<%} else{%>
			<div class="toprigh">
				pickupdate :<input type="date"  name="pickupdate" required />
				returndate :<input type="date" name="returndate" required/>
			</div>
			<%} %>
		  <div class="desc">
		  Price :
			<strong> US $15/Day</strong>
			<input type="hidden" value=15 name="carprice" />
			
			<input type="submit" value="select Car" id="toyotaButton"></input>
		 </div>
		</div>
		</form>
	<form action="selectCars" method="post">
		<div class="img">
		  <a target="_blank" href="mountains.jpg">
			<img src="image/honda.png" alt="Mountains" width="300" height="200">
		  </a>
		  <input type="hidden" value="<%=user %>" name="username" />
		  
		  <label id="hondalabel" value="honda" name="carname" >Honda</label></br>
			<input type="hidden" value="honda" name="carname" />
			
		  <label id="fordfulelabel" value="suv" name="suv" >Type : suv </label></br>
		  <input type="hidden" value="suv" name="cartype" />
		  
			<label id="fordlabel" value="diesel" name="fuel" >Fuel Type : Diesel</label></br>
			<input type="hidden" value="diesel" name="fueltype" />
			 <% if(location!=null && location!=""){ %>
				Location : <strong><%=location %></strong></br>
				<input type="hidden" name="location" value=<%=location %>/>
			<%} %> 
			<% if(indexPickupDate!=null && indexReturnDate!=null) {%>
				pickupdate : <%=indexPickupDate %></br>
				<input type="hidden" name="indexPickupDate" value=<%=indexPickupDate%>/>
				returndate : <%=indexReturnDate %></br>
				<input type="hidden" name="indexReturnDate" value=<%=indexReturnDate %>/>
			<%} else{%>
			<div class="toprigh">
				pickupdate :<input type="date"  name="pickupdate" required />
				returndate :<input type="date" name="returndate" required/>
			</div>
			<%} %>
		  <div class="desc">
		  Price :
			<strong> US $15/Day</strong>
			<input type="hidden" value=15 name="carprice" />
			<input type="submit" value="select Car" id="hondaButton"></input>
		 </div>
		</div>
		</form>
</div>
<%-- <%String Mcarname=(String)request.getAttribute("Mcarname"); %>
<%String Mpickupdate=(String)request.getAttribute("Mpickupdate"); %>
<%String Mreturndate=(String)request.getAttribute("Mreturndate"); %>
<%String Mcarprice=(String)request.getAttribute("Mcarprice"); %>
<div class="displaySchedule" id="displaySchedule"style="display:block">
	<h2>My Schedule</h2>
	<table>
		<tr>
			<th>Car Name</th>
			<th>Pickup Date</th>
			<th>Return Date</th>
			<th>Car Price</th>
		</tr>
		<tr>
			<td><%=Mcarname %></td>
			<td><%=Mpickupdate %></td>
			<td><%=Mreturndate %></td>
			<td><%=Mcarprice%></td>
		</tr>
	</table>
</div> --%>
</body>
</html>