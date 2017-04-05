function ValidationEvent() {
	var valid = true;
	var first_name = document.getElementById("first_name").value;
	var last_name = document.getElementById("last_name").value;
	var password = document.getElementById("password").value;
	var email = document.getElementById("email").value;
	var name_regex = /(^[A-Z]?[a-z]{1,15}$)|(^[А-Я]?[а-я]{1,15}$)/;
	var email_regex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	var password_regex = /^[a-zA-Z0-9_\\*\\!\\^]{6,15}$/;
	if (first_name != '' && last_name != '' && password != '' && email!=''){
		if (name_regex.test(first_name)) {
			if (name_regex.test(last_name)) {
				if (password_regex.test(password)) {
					if (email_regex.test(email)) {
						valid = true;
					} else {alert("Invalid Email Address"); valid = false;}
				} else {alert("Invalid password"); valid = false;}
			} else {alert("Invalid Last Name"); valid = false;}
		} else {alert("Invalid First Name"); valid = false;}
	} else {alert("Empty fields!"); valid = false;}
	return valid;
}

function clearField(msg,formID) {
    var str = document.getElementById(formID).value;
    if(str == msg)
        document.getElementById(formID).value='';
}

function restoreField(msg,formID) {
    var str = document.getElementById(formID).value;
    if(str == '')
        document.getElementById(formID).value=msg;
}

