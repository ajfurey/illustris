function userOutput(data) {
    var msg="";
    var msg2="";
    console.log(data)
    Object.keys(data).forEach(function(key) {
      msg+="<th>"+key+"</th>";
      msg2+="<td>"+data[key]+"</td>";
    })
    $("#userKey").html(msg);
    $("#userValue").html(msg2);
  }
  
  $(document).ready(function(){
    $.ajax({
            type : "GET",
            url : "/user/",
            contentType : "application/json",
            dataType:"JSON",
            success : userOutput
        })
  });
  
        
