<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%String contextpath = request.getContextPath(); %>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>



<script>

 platAlert =setInterval(function() {
    aa();
  }, 1000);
 

 
  
  
function aa(){
   if(document.reg_frm.checkuse.value ==  "true"){
      
      $(function(){
         $('.overlapment').text('중복확인 완료');
      })   
   }else if(document.reg_frm.checkuse.value ==  "false"){
      $(function(){
         $('.overlapment').text('중복확인 필요');
      })   
      
   }
   
}

function fn_press_han(obj)
{
    //좌우 방향키, 백스페이스, 딜리트, 탭키에 대한 예외
    if(event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 37 || event.keyCode == 39
    || event.keyCode == 46 ) return;
    //obj.value = obj.value.replace(/[\a-zㄱ-ㅎㅏ-ㅣ가-힣]/g, '');
    obj.value = obj.value.replace(/[\ㄱ-ㅎㅏ-ㅣ가-힣]/g, '');
}





function on(){

    
    var objEv = event.srcElement;
    var num ="{}[]()<>?_|~`!@#$%^&*-+\"'\\/ ";    //입력을 막을 특수문자 기재.
    event.returnValue = true;
     
    for (var i=0;i<objEv.value.length;i++)
    {
    if(-1 != num.indexOf(objEv.value.charAt(i)))
    event.returnValue = false;
    }
     
    if (!event.returnValue)
    {
     alert("특수문자는 입력하실 수 없습니다.");
     objEv.value="";
    }
    
   
   }





function checkID() {
   aa();
   
   var id = document.reg_frm.id.value;
   
   if(document.reg_frm.id.value.length < 4) {
      alert("아이디는 4글자 이상이어야 합니다.");
      reg_frm.id.focus();
      return;
   }
   
   
   if (id == '') {
      
      alert('아이디를 입력하세요');
      document.reg_frm.checkuse.value = false;
      
      return;
   }else if(id !=''){
   
      
      var url = '<%= contextpath %>/IdOverlapCheck.member?id=' + id;
       window.open(url, '', 'width=300, height=300, left=0, top=0');
      
         
   }

}





function enableID() {
   document.reg_frm.checker.disabled = false;
}


function disableID() {
   document.reg_frm.checker.disabled = true;
}




</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<meta name="viewport" content="width=device-width initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<script language="JavaScript" src="members.js">

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
</script>
<style>
input:focus {
   outline: 3px;
   outline-color: #58ACFA;
   outline-style: solid
}

input {
   boder: 2px solid #FFF;
   background-color: transparent;
}

#title {
   text-align: center;
   background-color: orange;
}
table{
position: relative;
left: 50px;
top: 10px;
}

#idcheck {
 width: 100px;
}
</style>
</head>
<body >

<%
      request.setCharacterEncoding("utf-8");
   
   %>
   
<jsp:include page="/menu.jsp"></jsp:include>

   &nbsp;
   
   &nbsp;

   
    <div class="container">
     
      <div class="col-lg-4">
         <div class="jumbotron" style="padding-top: 20px; width: 500px; left: auto;">
            <form method="post" action="<%=contextpath %>/join.app"  name ="reg_frm">
               <h3 style="text-align:center;">회원 가입 화면</h3>
              <div class="form-group">
                <input type="text" class="form-control" placeholder="이름" name="name"  maxlength="20"  style="ime-mode: active;" style="width: 100px;">
               </div>
               
               <div class="form-group">
                <input type="text" class="form-control" onKeyUp="on()" onkeydown="fn_press_han(this);"  placeholder="아이디" name="id" maxlength="20" style="ime-mode: disabled;" style="width: 150px;"> 
                <input type="button" class="btn btn-primary form-control" id = "idcheck" value="중복확인" onclick="checkID()"  >
                  <label class = "overlapment"></label><input type="hidden" name="checkuse" value="false" >
               </div>
               
               <div class="form-group">
                <input type="password" class="form-control" placeholder="비밀번호" name="password" maxlength="20" style="width: 150px;" >
               </div>
               
                <div class="form-group">
                <input type="text" class="form-control" onkeydown="fn_press_han(this);" placeholder="이메일" name="Email" maxlength="20" style="ime-mode: disabled;" style="width: 200px;">
               </div>
               
                   <div class="form-group" style="text-align: center;">
               <div class="btn-group" data-toggle="buttons">
               <label class="btn btn-primary active">
               <input type="radio" name="gender" autocomplete="off" value="남자" checked>남자
               </label>
               <label class="btn btn-primary">
               <input type="radio" name="gender" autocomplete="off" value="여자">여자
               </label>
               </div>
               </div>
             
               <input type="button" class="btn btn-primary form-control" value="회원가입" onclick="infoConfirm()">
           
            </form>
         </div>
         <div class="col-lg-4"></div>
      </div>
   
      </div>
   
  
      
  
</body>
</html>