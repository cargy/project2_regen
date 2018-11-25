var appId;

$(document).ready(function() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });

    $.ajax({
       url: ROOT_PATH + "/api/citizen/appointment/" + vars["appointment_id"],
       type: "GET",
       dataType: 'json',
       contentType: 'application/json',
       success: function(appointment){
           $('#date').attr("value", appointment.date);
           $('#time').timepicker("setTime",appointment.time);
           $('#illness').attr("value", appointment.illnessHistory);
           $('#notes').attr("value", appointment.notes);

           appId = appointment.appointmentId;
       },
       error: function(xhr,resp,text){
           alert("Could not load appointment's info.");
           history.go(-2);
       }
    });
});

function saveChanges(){

      var object = {
          'appointmentId' : appId,
          'date' : $("#date").val(),
          'time' : $("#time").val(),
          'illnessHistory' : $("#illness").val(),
          'notes' : $("#notes").val()
      };

      var requestData = JSON.stringify(object);

      $.ajax({
            "url": ROOT_PATH + "/api/citizen/appointment",
            "method": "PUT",
            "processData": false,
            "data": requestData,
            "contentType": "application/json",
            "dataType": "json",
            success: function(responseData, textStatus, jQxhr){
                alert("Changes saved successfully.");
                window.location.href = "cit_single_appointment.html?appointment_id=" + appId;
            },
            error : function(xhr, options, error){
                console.log(error);
            }

      });
}
