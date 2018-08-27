<html>
<style>
.paymentDiv{
				position: absolute;
				left: 35%;
				width : 40%;
				border: 1px solid #ccc;
				border-radius: 4px;
				box-sizing: border-box;
			}
input[type=submit] {
				position: relative;
				left : 32%;
			    width: 20%;
			    background-color: #4CAF50;
			    color: white;
			    padding: 15px 18px;
			    margin: 1px 0;
			    border: none;
			    border-radius: 10px;
			    cursor: pointer;
				}
</style>
	<body>
		<% String username=(String) request.getAttribute("username");%>
		<% String firstName=(String) request.getAttribute("firstname");%>
		<% String includingTax=(String) request.getAttribute("includingTax");%>
		<% String receiptNumber=(String) request.getAttribute("receiptNumber");%>
		<%if(username!=null && username!="") {%>
		<div>
			<form action="register" method="post">
		<input type="hidden" value="<%=username%>" name="username" />
		<input type="submit" value="go back to main page" >
		</form>
		</div>
		<div class="paymentDiv">
			<h2>Payment Confirmation </h2>
			<strong>Mr.<%=username%> </strong></br>
			you have paid<strong> USD $<%=includingTax %> /-</strong></br>
			and your receipt number is : <strong><%=receiptNumber%></strong></br>
			<span>Note : please remember receipt number for future reference :</span><strong><%=receiptNumber %></strong>
		</div>
		
		
		<%} else{%>
		<div class="paymentDiv">
			<h2>Payment Confirmation </h2>
			<strong>Mr.<%=firstName%> </strong></br>
			you have paid<strong> USD $<%=includingTax %></strong></br>
			<strong>and your receipt number is : <%=receiptNumber%></strong>
		</div>
		<a href="selectCars.jsp">go back to main page</a>
		<%} %>
			
</body>
</html>