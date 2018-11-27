function editAppointment() {

    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });

    window.location.href = "cit_edit_appointment.html?appointment_id=" + vars["appointment_id"];
}



