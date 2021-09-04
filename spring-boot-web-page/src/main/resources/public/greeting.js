$(document).ready(function(){
    $("#button").click(function(){
        var name = $("#name").val();
        $.ajax({
          type: "GET",
          url: "http://localhost:8080/greetings/" + name,
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