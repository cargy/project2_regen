$(document).ready(function(){
    $('#logoutButton').on('click', function(e){
        if(confirm("Are you sure you want to logout?")){
            sessionStorage.clear;
            window.location.replace(ROOT_PATH + "/logout")
        }
        return false;
    });
});
