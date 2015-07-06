<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>패스워드 비교</title>
<script type="text/javascript">
	function check_pass() {
		if(check_pass_form.PASSWORD.value == ""){
			alert("패스워드를 입력하세요");
			check_pass_form.PASSWORD.focus();
			return false;			
		}
	}
	
	function EndCheck() {
		window.opener.location.href = "<c:url value='BBS' />";
		self.close();
	}

	if("${CHECK_PASS}" == "update"){
		window.opener.location.href = "${url}";
		self.close();
	}else if("${CHECK_PASS}" == "reply"){
		window.opener.location.href = "${url}";
		self.close();
	}
</script>
</head>
<body>
	<div class="container-fluid">
		<c:choose>
			<c:when test="${CHECK_PASS eq 'fail'}">
				<br><b>패스워드가 틀렸습니다.</b>
				<form action="Check_Pass" method="GET" onsubmit="return check_pass()" name="check_pass_form">
					<input type="hidden" name="${BBS_NUM}">
					<input type="hidden" name="${BBS_TYPE}">
					패스워드:<input type="password" name="PASSWORD">
					<input type="submit" value="입력"> 
				</form>		
			</c:when>
			<c:when test="${CHECK_PASS eq 'delete' }">
				<p>삭제 되었습니다.</p>
				<button onclick="EndCheck()">닫기</button>
			</c:when>
			<c:otherwise>
				<form action="Check_Pass" method="GET" onsubmit="return check_pass()" name="check_pass_form">
					<input type="hidden" name="BBS_NUM" value="${BBS_NUM}">
					<input type="hidden" name="BBS_TYPE" value="${BBS_TYPE}">
					패스워드:<input type="password" name="PASSWORD">
					<input type="submit" value="입력"> 
				</form>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>