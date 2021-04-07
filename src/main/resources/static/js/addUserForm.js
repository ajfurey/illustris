"use strict";



$("#submit").click(function(){
	var firsName=$("#firsName").val();
    var lastName=$("#lastName").val();
    var username=$("#username").val();
	var email=$("#email").val();
	var phone=$("#phone").val();
    var address=$("#address").val();
    var title=$("#title").val();
    var hireDate=$("#hireDate").val();
    var enabled=$("#enabled").val();
    var locked=$("#locked").val();
    var userRole=$("#userRole").val();
	
    
    var data={
		firsName:firsName,
        lastName:lastName,
        username:username,
		email:email,
        phone:phone,
        address:address,
        title:title,
        hireDate:hireDate,
        enabled:enabled,
        locked:locked,
        userRole:userRole,
	};
	$.post("/user", data);
});