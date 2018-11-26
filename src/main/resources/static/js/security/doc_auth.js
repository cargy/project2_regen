if(!sessionStorage.getItem(SESSION_STORAGE_ROLE_NAME)){
    alert("You are not authorized to access this url.");
    window.location.replace(ROOT_PATH + "/index.html");

} else if (sessionStorage.getItem(SESSION_STORAGE_ROLE_NAME)=="CITIZEN") {
    alert("You are not authorized to access this url.");
    window.location.replace(ROOT_PATH + "/users/citizen/index.html");
}
