$(document).ready(function(){
    $("#byPathVariable").click(function(){
        $.ajax({
          type: "GET",
          url: "http://localhost:8080/greetings/" + $("#name").val(),
          cache: false,
          success: function(data){
             $("#paragraf").text(data + "... Using path variable");
          },
          error: function(data) {
              alert(data);
          }
        });
    });

    $("#byRequestParam").click(function(){
        $.ajax({
          type: "GET",
          url: "http://localhost:8080/greetings/byParameter",
          data: { 
            name: $("#name").val()
          },
          cache: false,
          success: function(data){
             $("#paragraf").text(data + "... Using request parameter");
          },
          error: function(data) {
              alert(data);
          }
        });
    });    
    
   
});

function obtrusiveByParameter(parameter){
    $.ajax({
      type: "GET",
      url: "http://localhost:8080/greetings/byParameter",
      data: { 
        name: parameter
      },
      cache: false,
      success: function(data){
         $("#paragraf").text(data + "... Using request parameter with obtrusive JS!");
      },
      error: function(data) {
          alert(data);
      }
    });
} 