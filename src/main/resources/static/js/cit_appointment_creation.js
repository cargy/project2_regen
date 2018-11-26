$(document).ready(function(){

    loadSpecialties("specialty");

    $("#doctor").prop('disabled', true);
    $("#createAppointmentButton").prop('disabled', true);
    $("#appointmentDateInput").prop('disabled', true);
    $("#appointmentTimeInput").prop('disabled', true);
    $("#appointmentIllnessHistoryInput").prop('disabled', true);
    $("#appointmentNotesInput").prop('disabled', true);


    $('#specialty').change(function(){
        var value = $(this).val();
        if(value>=1){
             $("#doctor").prop('disabled', false);
             $("#createAppointmentButton").prop('disabled', false);
             $("#appointmentDateInput").prop('disabled', false);
             $("#appointmentTimeInput").prop('disabled', false);
             $("#appointmentIllnessHistoryInput").prop('disabled', false);
             $("#appointmentNotesInput").prop('disabled', false);
              $.ajax({
                      "url" : ROOT_PATH + "/api/citizen/doctor/" + value,
                      "method" : "GET",
                      "contentType": "application/json",
                      "dataType": "json",
                      success : function(response) {
                             $("#doctor").empty();
                             $("#doctor").append(
                                     $(
                                         '<option>',
                                         {
                                             value :"0",
                                             text : "Choose Doctor..."
                                         }
                                     )
                                 );
                          response.forEach(function(doctor){
                             $("#doctor").append(
                                 $(
                                     '<option>',
                                     {
                                         value :doctor.doctorId,
                                         text : doctor.firstname + " " + doctor.lastname
                                     }
                                 )
                             );
                          });
                      },
                      error: function(xhr,ajaxOptions,thrownError){
                            alert("Error");
                      }
                 });
        }else{
            $("#doctor").prop('disabled', true);
            $("#createAppointmentButton").prop('disabled', true);
            $("#appointmentDateInput").prop('disabled', true);
            $("#appointmentTimeInput").prop('disabled', true);
            $("#appointmentIllnessHistoryInput").prop('disabled', true);
            $("#appointmentNotesInput").prop('disabled', true);
        }
    });

    $("#createAppointmentButton").click(function() {

        var object = {
            'doctorId' : parseInt($("#doctor").val()),
            'date' : $("#appointmentDateInput").val(),
            'time' : $("#appointmentTimeInput").val(),
            'illnessHistory' : $("#appointmentIllnessHistoryInput").val(),
            'notes' : $("#appointmentNotesInput").val()
        };

        var requestData = JSON.stringify(object);

        if($("#appointmentDateInput").val() != "" && $("#appointmentTimeInput").val() != "" && $("#doctor").val() > 0) {

            $.ajax({
                    "url": ROOT_PATH + "/api/citizen/appointment",
                    "method": "POST",
                    "processData": false,
                    "data": requestData,
                    "contentType": "application/json",
                    "dataType": "json",
                    success: function(responseData, textStatus, jQxhr){
                        alert("Your appointment created successfully.")
                    },
                    error : function(xhr, options, error){
                        console.log(error);
                    }
           });
        } else {
          alert("Please fill the fields date, time and doctor which are required!")
        }
    });
});