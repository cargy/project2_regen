$(document).ready(function(){
    $('#logoutButton').on('click', function(e){
        if(confirm("Are you sure you want to logout?"))
            sessionStorage.clear;
            window.location.replace= "http://localhost:8080/index.html";
        return false;
    });
});