
function myLogin(usernameElement,passwordElement) {
	let username = usernameElement && usernameElement.value ? usernameElement.value : "";
	let password = passwordElement && passwordElement.value ? passwordElement.value : "";

	alert("un="+username+"\npw="+password);

	var fd = new FormData();
	fd.append( 'username', username);
	fd.append( 'password', password);

	alert(String(fd));

	$.ajax({
	url: 'http://localhost:8080/login',
	data: fd,
	processData: false,
	contentType: false,
	type: 'POST',
	success: function(data){
	sessionStorage.setItem('SESSION_STORAGE_LOGIN_TOKEN_NAME', username);
	window.location.replace("http://localhost:8080/dashboard/doc_search.html");
	},
	statusCode: {
	401 : function() {
		alert("Invalid username or password!");
	    }
	}
	});

}

function register() {
    // TODO:
}
