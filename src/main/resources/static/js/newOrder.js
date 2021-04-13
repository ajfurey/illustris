

$(document).ready(function(){

  $("#find").click(function(){
      
    var patientName= $("#patientName").val()
      var birthDate1=$("#birthDate1").val();
     
      
      var data={
          "birthDate1":birthDate1,
          "patientName":patientName,
      };

      console.log(data);
      /*$.ajax({
          type : "GET",
          url : "/user",
          contentType : "application/json",
          data : JSON.stringify(data),
      })*/
  });
});