//loads db specialties in the html element with id: id
function loadSpecialties(selectorId){
    $.ajax({
         "url" : ROOT_PATH + "/api/citizen/specialties",
         "method" : "GET",
         "contentType": "application/json",
         "dataType": "json",
         success : function(response) {
             response.forEach(function(specialty){
                $("#"+selectorId).append(
                    $(
                        '<option>',
                        {
                            value : specialty.specialtyId,
                            text : specialty.specialty
                        }
                    )
                );
             });
         },
         error : function(xhr, options, error){
            console.log(error);
         }
    })
}