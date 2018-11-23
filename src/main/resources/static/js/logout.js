function logout(){
    if(confirm("Are you sure you want to logout?")){
        sessionStorage.clear();
        window.location.replace(ROOT_PATH + "/logout")
    }
}