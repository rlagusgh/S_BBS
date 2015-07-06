<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script src="resources/js/form.js" type="text/javascript" charset="utf-8"></script>
<link rel="Stylesheet" href="resources/css/bbs.css" />
<title>게시물 등록</title>
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
		<form action="write" method="POST" name="form" id="form"
			onsubmit="return Check()">
			<TABLE border='0' width='600'>
				<TR>
					<TD width='100' id="bg"><font size='2'><center>
								<b>작성자</b>
							</center></font></TD>
					<TD>
						<p>
							<input type='text' size='14' name='NAME'
								style="ime-mode: active;" onKeyPress="code();"> * 필수
						</p>
					</TD>
				</TR>

				<TR>
					<TD width='100' id="bg"><font size='2'><center>
								<b>비밀번호</b>
							</center></font></TD>
					<TD>
						<p>
							<input type='password' size='14' name='PASSWORD'
								id="tr_bgcolor_2"> * 필수 (게시물 수정 삭제시 필요합니다.)`
						</p>
					</TD>
				</TR>

				<TR>
					<TD width='100' id="bg"><font size='2'><center>
								<b>E-mail</b>
							</center></font></TD>
					<TD><font size='2'><input type='text' size='40'
							maxlength='50' name='EMAIL' style="ime-mode: inactive;"
							placeholder="abc@abc.com"></font>
					<p></p></TD>
				</TR>

				<TR>
					<TD width='100' id="bg"><font size='2'><center>
								<b>글 제목</b>
							</center></font></TD>
					<TD><font size='2'><input type='text' size='69'
							maxlength='50' name='TITLE' style="ime-mode: active;"></font>
					<p></p></TD>
				</TR>

				<TR>
					<TD width='100' id="bg"><font size='2'><center>
								<b>글 내용</b>
							</center></font></TD>
					<TD><font size='2'> <textarea cols='70' rows='15'
								name='CONTENTS' style="ime-mode: active;"></textarea>
					</font></TD>
				</TR>

				<TR>
					<TD colspan='2'>
						<HR size=5px color="black" width=600px>
					</TD>
				</TR>

				<TR>
					<TD align='center' colspan='2' width='100%'>
						<TABLE>
							<TR>
								<TD width='100' align='center'><input type='Reset'
									Value='다시 작성'></TD>

								<TD width='200' align='center'><input type='Submit'
									Value='등록'></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>
		</FORM>
	</div>
</body>
</html>