$(document).ready(function() {

    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    $.ajax({
       url: ROOT_PATH + "/api/doctor/appointment/"+vars["appointment_id"],
       type: "GET",
       dataType: 'json',
       contentType: 'application/json',
       success: function(appointment){
           $('#date').html(appointment.date);
           $('#time').html(appointment.time);
           $('#illness').html(appointment.illnessHistory);
           $('#notes').html(appointment.notes);

           var citId = appointment.citizen.citizenId;
           $.ajax({
              url: ROOT_PATH + "/api/doctor/citizen/"+citId,
              type: "GET",
              dataType: 'json',
              contentType: 'application/json',
              success: function(citizen){
                  $('#ssn').html(citizen.ssn);
                  $('#fname').html(citizen.firstname);
                  $('#lname').html(citizen.lastname);
                  $('#email').html(citizen.email);
                  $('#phone').html(citizen.phone);
              },
              error: function(xhr,resp,text){
                  alert("Could not load patient's info.");
              }
           });
       },
       error: function(xhr,resp,text){
           alert("Could not load appointment's info.");
           history.go(-1);
       }
    });
});