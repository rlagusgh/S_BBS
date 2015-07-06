<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function CHECK_PASS(TYPE){
		var url = "Check_Pass?BBS_NUM="+${BBS.BBS_NUM}+"&BBS_TYPE="+TYPE;
		window.open(url,"패스워드입력","width=500,height=300");
	}
</script>
</head>
<body>
	<div class="container" align="center">
		<a href="BBS" style="text-decoration: none;">
			<div class="jumbotron" align="center">
				<h1>
					BBS<br>(Bulletin Board System)
				</h1>
			</div>
		</a>
		<TABLE border='0' width='600'>
			<TR>
				<TD align='left'><font size='2'> 작성자 : ${BBS.NAME} (${BBS.EMAIL })</font></TD>

				<TD align=right><font size='2'>작성일: ${BBS.CRE_DATE} ,
						조회수: ${BBS.READCOUNT}</font></TD>
			</TR>
		</TABLE>

		<TABLE border='0' cellspacing=3 cellpadding=3 width='600'>
			<TR>
				<TD align='center'><font size='3'>${BBS.TITLE}</font></TD>
			</TR>
		</TABLE>

		<center>
			<TABLE border='0' cellspacing=5 cellpadding=10 width='600'>
				<TR>
					<TD><font size='2'><textarea rows="15" cols="84"
								readonly="readonly">${BBS.CONTENTS}</textarea></font></TD>
				</TR>
			</TABLE>
		</center>

		<HR size='5px' width=600px>
		
		<TABLE border='0' width='600'>
			<TR>
				<TD align='left'>
						<button type="button" onclick="CHECK_PASS('UPDATE')">수정하기</button>
						<button type="button" onclick="CHECK_PASS('DELETE')">삭제하기</button>
				</TD>
				<TD align='right'>
						<a href="ReplyForm?BBS_NUM=${BBS.BBS_NUM }">
						<button>답변하기</button></a>
				<a href='writeForm'>
						<button>글쓰기</button>
				</a> <a href='BBS'>
						<button>목록보기</button>
				</a></TD>
			</TR>
		</TABLE>
	</div>
</body>
</html>