function mySchedule(){
	
	var xmlHttp= GetXmlHttpObject();

	var username=document.getElementById("manageuser").value;
	var url="printName";
	console.log(" user name :"+username);
	console.log("url : "+url);
	xmlHttp.open("GET",url,true);
	xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded"); 
	xmlHttp.send("username="+username);
	
	xmlHttp.onreadystatechange  = function (){
		if (xmlHttp.readyState == 4) {
			 if(xmlHttp.status == 200) {
				 console.log(" user name :"+username);
				 console.log("url : "+url);
				 var response= xmlHttp.responseText; 
				 console.log(response);
				 window.location.replace("manageSchedule.jsp");
				 console.log(typeof response);
				 console.log("username : "+username);
				 document.getElementById("usernamelist").innerHTML= " Hello "+response;
			}
			 else {  alert("ajax call failed");}}
		
	};
	
}

function GetXmlHttpObject(){ 
	var xmlHttp=null;
try { 
  xmlHttp=new XMLHttpRequest(); }
catch (e)
 { 
  try{  xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");    }
  catch (e) {  xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");    }
 } return xmlHttp;
}