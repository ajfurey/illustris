
function patientOutput(data) {
  alert(data.firstName);
  var msg="";
  var msg2="";
  Object.keys(data).forEach(function(key) {
    msg+="<th>"+key+"</th>";
    msg2+="<td>"+data[key]+"</td>";
  })
  $("#bob").html(msg);
  $("#frank").html(msg2);
}

$(document).ready(function(){

  $("#find").click(function(){
      
    var patientName= $("#patientName").val()
      var birthDate1=$("#birthDate1").val();
     
      
      var data={
          "patientBDay":birthDate1,
          //"patientName":patientName,
      };

      console.log(data);
      $.ajax({
          type : "GET",
          url : "/patient/onePatient",
          contentType : "application/json",
          data : data,
          dataType:"JSON",
          success : patientOutput
      })
  });
});