<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.lang.String" %>
    <%@ page import="java.util.Date" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=text], select {
				width: 30%;
				padding: 12px 20px;
				margin: 5px 0;
				display: inline-block;
				border: 1px solid #ccc;
				border-radius: 4px;
				box-sizing: border-box;
			}
			input[type=number],[type=email]{
				width: 60%;
				padding: 12px 20px;
				margin: 5px 0;
				display: inline-block;
				border: 1px solid #ccc;
				border-radius: 4px;
				box-sizing: border-box;
			}
			input[type=submit] {
				width: 30%;
				background-color: #4CAF50;
				color: white;
				padding: 14px 20px;
				margin: 5px 0;
				border: none;
				border-radius: 4px;
				cursor: pointer;
			}
			.creditcardBlock{
				width : 40%;
				border: 1px solid #ccc;
				border-radius: 4px;
				box-sizing: border-box;
			}
			#creditId{
				width:100%;
			}
</style>
<body>
	<%String  carName=(String)request.getAttribute("carName");%>
	<%String  carType=(String)request.getAttribute("carType");%>
	<%String  fuelType=(String)request.getAttribute("fuelType");%>
	<%int  carPrice=(Integer)request.getAttribute("carPrice");%>
	<%String  pickupdate=(String)request.getAttribute("pickupdate");%>
	<%String  returndate=(String)request.getAttribute("returndate");%>
	<%int  multiprice=(Integer)request.getAttribute("multiprice");%>
	<%int  days=(Integer)request.getAttribute("days");%>
	<%int  tax=(Integer)request.getAttribute("tax");%>
	<%int  includingTax=(Integer)request.getAttribute("includingTax");%>
	
	<%String user=(String)request.getAttribute("username");%>
		                                                               
<div>
	<% if(user!=null && user!="") {%>
	car user: <strong> <%=user%></strong></br>
	<%}else if(user==null){ %>
		 <strong>Welcome guest</strong></br>
	<%} %>
	Car Name :<strong> <%=carName %></strong></br>
	Car Type : <strong><%=carType %></strong></br>
	Fuel Type :<strong><%=fuelType %></strong></br>
	pickup Date :<strong><%=pickupdate %></strong></br>
	Return Date :<strong><%=returndate %></strong></br>
	Car Price : <strong>USD $ <%=carPrice %>/Day</strong></br>
	you have booked for <strong><%=days %></strong><% if(days>1){%><strong>days</strong>
	<% }else{%><strong>day</strong><%} %></br>
	Tax includes <strong><%=tax %> %</strong></br>
	Total price including tax : <strong>USD $<%=includingTax %>/-</strong>
</div>
	<%if(user!=null && user!=""){ %> 
		<div class="creditcardBlock">
			<form action="payment" method="post">
			
			<input type="hidden"  name="user" value="<%=user %>" />
			<input type="hidden"  name="carName" value="<%=carName %>" />
			<input type="hidden"  name="carType" value="<%=carType %>" />
			<input type="hidden"  name="fuelType" value="<%=fuelType %>" />
			<input type="hidden"  name="pickupdate" value="<%=pickupdate %>" />
			<input type="hidden"  name="returndate" value="<%=returndate %>" />
			<input type="hidden"  name="days" value="<%=days %>"/>
			<input type="hidden"  name="tax" value="<%=tax%>"/>
			<input type="hidden"  name="includingTax" value="<%=includingTax %>" />
			
			<h2>Credit card or Debit card</h2>	
			<input type="text" id="creditId" name="creditcardnumber" placeholder="16 Digit credit card number"  required /></br>		
			<select id="months" name="month" value=this.value>
				<option value="january">January</option>
				<option value="february">February</option>
				<option value="march">March</option>
				<option value="april">April</option>
				<option value="may">May</option>
				<option value="june">June</option>
				<option value="july">July</option>
				<option value="august">August</option>
				<option value="september">September</option>
				<option value="october">October</option>
				<option value="november">November</option>
				<option value="december">December</option>
			</select>
			<input type="number"   name="year" min="2017" max="2027">
			<input type="number"   name="cvv" min="100" max="999" placeholder="cvv"></br>
			<input type="submit" value="Proceed for Payment">
			</form>
			</div>
			<%} else if(user==null){%>
				<div class="creditcardBlock">
				<form action="payment" method="post">
				
				<input type="hidden"   name="carName" value="<%=carName %>" />
				<input type="hidden"  name="carType" value="<%=carType %>" />
				<input type="hidden"  name="fuelType" value="<%=fuelType %>" />
				<input type="hidden"  name="pickupdate" value="<%=pickupdate %>" />
				<input type="hidden"  name="returndate" value="<%=returndate %>" />
				<input type="hidden"  name="days" value="<%=days %>" />
				<input type="hidden"  name="tax" value="<%=tax%>" />
				<input type="hidden"  name="includingTax" value="<%=includingTax %>" />	
				
				<h2>Driver Information</h2>
				
				<input type="text" id="" name="firstname" placeholder="First Name" required />
				<input type="text" id="" name="lastname" placeholder="last Name" required />
				<input type="email" id="" name="email" placeholder="Email Address" required /></br>
				<input type="email" id="" name="confirmemail" placeholder="Confirm Email Address" required /></br>
				<input type="text" id="" name="phonenumber" placeholder="phone number" required />
				<label>proceed for payment information</label>
				</div>
			<div class="creditcardBlock">
			
			<h2>Credit card or Debit card</h2>	
			<input type="text" id="" name="creditcardnumber" placeholder="16 Digit credit card number" pattern="[0-9\-]+" required /></br>		
			<select id="months" name="month" value=this.value>
				<option value="january">January</option>
				<option value="february">February</option>
				<option value="march">March</option>
				<option value="april">April</option>
				<option value="may">May</option>
				<option value="june">June</option>
				<option value="july">July</option>
				<option value="august">August</option>
				<option value="september">September</option>
				<option value="october">October</option>
				<option value="november">November</option>
				<option value="december">December</option>
			</select>
			<input type="number"   name="year" min="2017" max="2027" placeholder="Year">
			<input type="number"   name="cvv" min="100" max="999" placeholder="cvv"></br>
			<input type="submit" value="Proceed for Payment">
			</form>
			</div>
			<%}%>
</body>
</html>