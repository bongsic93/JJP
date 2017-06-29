/**
 * 
 */

function infoConfirm() {
	if(document.reg_frm.id.value.length == 0) {
		alert("아이디는 필수 사항입니다.");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.id.value.length < 4) {
		alert("아이디는 4글자 이상이어야 합니다.");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.id.value.length > 20) {
		alert("아이디는 20글자 이하이어야 합니다.");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.password.value.length == 0) {
		alert("비밀번호는 필수 사항입니다.");
		reg_frm.password.focus();
		return;
	}
	
	
	
	if(document.reg_frm.name.value.length == 0) {
		alert("이름은 필수 사항입니다.");
		reg_frm.name.focus();
		return;
	}
	
	if(document.reg_frm.id.value.length == 0) {
		alert("아이디는 필수 사항입니다.");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.checkuse.value == 'false') {
		alert("아이디를 중복확인 해주세요.");
		return;
	}
	
	document.reg_frm.submit();
}

function loginConfirm() {
	if(document.lg_frm.id.value.length == 0) {
		alert("아이디는 필수 사항입니다.");
		lg_frm.id.focus();
		return;
	}
	
	if(document.lg_frm.password.value.length == 0) {
		alert("비밀번호는 필수 사항입니다.");
		lg_frm.password.focus();
		return;
	}

	document.lg_frm.submit();

}



