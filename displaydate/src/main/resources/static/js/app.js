let path = window.location.pathname;
console.log(path);
function welcome(path){
	

	if (path == "/time/"){
		alert("This is the time template")
	}
	else if (path == "/date/") {
		alert("This is the date template")
	} 
	else {
		alert("welcome")
	}
}
welcome(path);
console.log(path);
