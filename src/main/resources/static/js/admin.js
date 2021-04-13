function userOutput(data) {
    var msg="";
    var msg2="";

    var bob=data[1].firstName.toString()
    
 
    
    for(let i=0; i<data.length; i++){
      var tom=data[i];
      msg2+="<tr>"
      Object.keys(tom).forEach(function(key) {
        if(!i>0){
          msg+="<th>"+key+"</th>";
        }
        msg2+="<td>"+tom[key]+"</td>";
      })
      msg2+="</tr>"
    }
   
    

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
  
        
