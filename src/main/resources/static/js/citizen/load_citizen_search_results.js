$(document).ready(function() {

    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });

     $.ajax({
        url: ROOT_PATH + "/api/citizen/appointments",
        data: {"fromDate" : vars["from"],
                "toDate" : vars["to"],
                "specialty" : vars["specialty_id"]},
        type: "GET",
        dataType: 'json',
        contentType: 'application/json',
        success: function(appointments){
            var table = $('#appointments_table').DataTable( {
                 "data": appointments,
                 "order": [[ 1, "asc" ]],
                 "columns": [
                      { "data" : "appointmentId"},
                      { "data" : "date"},
                      { "data" : "time" }
                 ],
                 "columnDefs": [
                    {"className": "dt-center", "targets": "my-th-center"},
                    {"type": "num", "targets": 0 },
                    {"width": "150", "targets": 0}
                 ],
                 "language": {"emptyTable": "No appointments available to display."}
            });

            $('#appointments_table tbody').on('click', 'tr', function () {
                var data = $(this).find('td:first').text();
                if($.isNumeric(data)){
                    window.location.href = "cit_single_appointment.html?appointment_id="+data;
                }
            });
        },
        error: function(xhr,resp,text){
            alert("Could not load appointments.");
        }
     });
});