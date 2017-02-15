function boardCheck() {
	var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

	if(document.frm.name.value.length == 0){
		alert("작성자를 입력하세요");
		return false;
	}
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요");
		return false;
	}
	if(document.frm.title.value.length == 0){
		alert("제목을 입력하세요");
		return false;
	}
	if(document.frm.email.value.length != 0 && re.test(document.frm.email.value) == false){
		alert("올바른 이메일 주소를 입력하세요");
		return false;
	}
	return true;
}

function open_win(url,name) {
	window.open(url,name,"width=500, height=230");
}

function passCheck() {
	if(document.frm.pass.value.length == 0){
		alert("비밀번호를 입력하세요");
		return false;
	}
	return true;
}
