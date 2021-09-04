$(document).ready(function(){
    $("#byPathVariable").click(function(){
        $.ajax({
          type: "GET",
          url: "http://localhost:8080/greetings/" + $("#name").val(),
          cache: false,
          success: function(data){
             $("#paragraf").text(data);
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
             $("#paragraf").text(data);
          },
          error: function(data) {
              alert(data);
          }
        });
    });    
});