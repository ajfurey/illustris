$(document).ready(function(){
    $("#uploadOne").click(function(){
        var description=$("#description").val();
        var fileDatas=$("#fileDatas").val();
        var data={
            "description":description,
            "fileDatas":fileDatas,
        }
        console.log(data);
        $.ajax({
            type : "POST",
            url : "/upload/oneFile",
            enctype:"multipart/form-data",
            contentType : "application/json",
            data : JSON.stringify(data),
        })
    });
});