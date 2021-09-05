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
    
    $("#pojoFormSubmit01").click(function(){
        var pojo = {
            id: new Number($("#pojoFormId01").val()),
            string: $("#pojoFormString01").val()
        }
        $.ajax({
            crossDomain: true,
            url: 'http://localhost:8080/pojo/toUpperCase',
            type : "POST", 
            dataType : "json",
            contentType: "application/json",
            data : JSON.stringify(pojo),
            success : function(data) {
                $("#pojoParagraf01").text(JSON.stringify(data));
            },
            error: function(xhr, resp, text) {
                console.log(xhr, resp, text);
            }
        })
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