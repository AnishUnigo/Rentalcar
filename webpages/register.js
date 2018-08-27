
function names(){
				var xmlHttp= GetXmlHttpObject();
				var firstname=document.getElementById("fname").value;
				var lastname=document.getElementById("lname").value;
		
				var fullname= firstname+lastname;
				var url="register";
			
				xmlHttp.open("POST",url,true);
				xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
				xmlHttp.send("fullname="+fullname);
				
				xmlHttp.onreadystatechange  = function (){
					if (xmlHttp.readyState == 4) {
						 if(xmlHttp.status == 200) {
						  var response= xmlHttp.responseText; 
						 	console.log(":"+response+":");
							 if(firstname=="" || lastname==""){
							 	if(firstname=="" && lastname!=""){
								 document.getElementById("ajaxcall").innerHTML="first name please";
									document.getElementById("ajaxcall").style.color="red";
								}else if(firstname!="" && lastname==""){
								 document.getElementById("ajaxcall").innerHTML="last name please";
									document.getElementById("ajaxcall").style.color="red";
								 }else if(firstname=="" && lastname==""){
								 document.getElementById("ajaxcall").innerHTML="what is your name";
									document.getElementById("ajaxcall").style.color="red";
							 }
						 }else if(response=="error") {
							  console.log("printing error"+response);
								document.getElementById("ajaxcall").innerHTML="Name already exist";
								document.getElementById("ajaxcall").style.color="red";
						 	} else{
						 		document.getElementById("ajaxcall").innerHTML="";
						 	} 	 
						}
						 else {  alert("ajax call failed");}}
					
				};
			}
			
			function onEmail(){
				var xmlHttp= GetXmlHttpObject();
				var email=document.getElementById("emailid").value;
				var url="register";
			
				xmlHttp.open("POST",url,true);
				xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
				xmlHttp.send("email="+email);
				xmlHttp.onreadystatechange  = function (){
					if (xmlHttp.readyState == 4) {
						 if(xmlHttp.status == 200) {
						  var response= xmlHttp.responseText; 
						 	console.log(":"+response+":");
						 	
						  if(email=="") {
							  console.log("email is empty");
								document.getElementById("emailajax").innerHTML="email is must";
								document.getElementById("emailajax").style.color="red";
						 	} else if(response=="error"){
						 		console.log("email already exist");
						 		document.getElementById("emailajax").innerHTML="email already exist";
						 		document.getElementById("emailajax").style.color="red";
						 	}else{
						 		document.getElementById("emailajax").innerHTML="";
						 	} 	 
						  
						}
						 else {  alert("ajax call failed");}}
					
				};
			}
		function onPassword(){
			console.log("entered in onPassword() method ");
			var password={"uppercase":["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",],
					"specialcase":["/","*","-","+","!","@","#","$","%","^","&","*","(",")","_","[","]","?","<",">","/","'\'",":",";"]
			
		};
			var pwd=document.getElementById("pwd").value;
			var jsonPswd =JSON.Parse(password);
			console.log(jsonPswd.uppercase[0]);
			var i=null;
			for(i=0;i<=jsonPswd.uppercase.length;i++){
				if(jsonPswd.uppercase[i].contains(pwd)){
					continue;
				}else{
					console.log(jsonPswd.uppercase[i]);
					document.getElementById("pwdspan").innerHTML="Password must contain uppercase";
				}
			}
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
			
			