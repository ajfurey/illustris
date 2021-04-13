

$(document).ready(function(){

    $("#submit").click(function(){
        var firstName= $("#firstName").val();
        var lastName=$("#lastName").val();
        var username=$("#username").val();
        var email=$("#email").val();
        var password=$("#password").val();
        var phone=$("#phone").val();
        var address=$("#address").val();
        var title=$("#title").val();
        var hireDate=$("#hireDate").val();
        var enabled=true;
        var locked=false;
        var userRole=$("#userRole").val();
        userRole="ROLE_".concat(userRole.toUpperCase());
        
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
        /*var formData = $("form").serializeArray();
        data=[];
        event.preventDefault();
        $.each(formData, function(i, field) {
            data.push(field.name +":"+ field.value);
        });*/
        console.log(data);
        $.ajax({
            type : "POST",
            url : "/user",
            contentType : "application/json",
            data : JSON.stringify(data),
        })
    });
});