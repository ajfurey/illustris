

$(document).ready(function(){

    $("#submit").click(function(){
        var firstName= $("#firstName").val()
        var lastName=$("#lastName").val();
        var username=$("#username").val();
        var email=$("#email").val();
        var password=$("#password").val();
        var phone=$("#phone").val();
        var address=$("#address").val();
        var title=$("#title").val();
        var hireDate=$("#hireDate").val();
        var enabled=$("#enabled").val();
        var locked=$("#locked").val();
        var userRole=$("#userRole").val();
        
        
        
        var data={
            "firstName":firstName,
            "lastName":lastName,
            "username":username,
            "email":email,
            "password":password,
            "phone":phone,
            "address":address,
            "title":title,
            "hireDate":hireDate,
            "enabled":enabled,
            "locked":locked,
            "userRole":userRole
        };
        //alert("hi" +lastName)
        //var data = $("form").serializeArray();
        console.log( data );
        event.preventDefault();
        //alert("hi" +data)
        $.ajax({
            type : "POST",
            url : "/user",
            contentType : "application/json",
            data : JSON.stringify(data),
        })
    });
});