$(document).ready(function(){
    loadSpecialties("specialtySelector");
});

function showSearchResults() {
    var dateFrom = $('#date_from').val();
    var dateTo = $('#date_to').val();
    var selected_specialty_id = $("#specialtySelector option:selected").val();

    if (selected_specialty_id == 0) {
        var myURI = 'from=' + dateFrom + '&to=' + dateTo;
        var myEncodedURI = encodeURI(myURI);
    }else {
        var myURI = 'from=' + dateFrom + '&to=' + dateTo + '&specialty_id=' + selected_specialty_id;
        var myEncodedURI = encodeURI(myURI);
    }

    $(location).attr('href','cit_appointments.html?' + myEncodedURI);
}

