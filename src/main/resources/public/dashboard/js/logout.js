$(document).ready(function(){
    $('#logoutButton').on('click', function(e){
        if(confirm("Are you sure you want to logout?"))
            window.location.href = "http://localhost:8080/index.html";
        return false;
    });
});