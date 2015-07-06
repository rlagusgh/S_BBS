function Check() {
	if (form.NAME.value.length < 1) {
		alert("작성자를 입력하세요.");
		form.NAME.focus();
		return false;
	}

	if (form.PASSWORD.value.length < 1) {
		alert("비밀번호를 입력하세요.");
		form.PASSWORD.focus();
		return false;
	}

	if (form.EMAIL.value.indexOf("@") + "" == "-1"
			|| form.email.value.indexOf(".") + "" == "-1"
			|| form.email.value == "") {
		alert("E-mail을 입력하세요.");
		form.EMAIL.focus();
		return false;
	}

	if (form.TITLE.value.length < 1) {
		alert("글제목을 입력하세요.");
		form.TITLE.focus();
		return false;
	}

	if (form.CONTENTS.value.length < 1) {
		alert("글내용을 입력하세요.");
		form.CONTENTS.focus();
		return false;
	}
}

function hangul() {
	if ((form.keyCode < 12592) || (event.keyCode > 12687)) {
		event.returnValue = false;
		alert("한글만 입력하세요.");
	}
}

function code() {
	var key = form.keyCode;
	if ((key > 32 && key < 48) || (key > 57 && key < 65)
			|| (key > 90 && key < 97)) {
		form.returnValue = false;
		alert("특수문자는 입력할수 없습니다.");
	}
}