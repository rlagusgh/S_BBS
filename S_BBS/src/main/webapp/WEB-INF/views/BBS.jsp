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
<title>게시판</title>
<script type="text/javascript">
	function Check_search() {
	    if (search.KEYWORD.value.length < 1) {
	        alert("검색어를 입력하세요.");
	        search.KEYWORD.focus();
	        return false;
	    }
	}
	
	function write_href() {
		location.href = '<c:url value="/writeForm" />';
	}
</script>
</head>
<body>
	<div class="container">
	<a href="BBS" style="text-decoration: none;">
		<div class="jumbotron" align="center">
			<h1>
				BBS<br>(Bulletin Board System)
			</h1>
		</div>
	</a>
	
	<div align="center">
		<table border="1" cellspacing=1 cellpadding=5 width='600'>
			<thead style="background: gray;">
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>글쓴이</td>
					<td>작성날짜</td>
					<td>조회수</td>
				</tr>
			</thead>
			<c:forEach var="bbs" items="${BBS }">
			<tr>
				<td>${bbs.BBS_NUM }</td>
				<td width="240px"><a href="writeView?BBS_NUM=${bbs.BBS_NUM }">
											${bbs.TITLE}</a></td>
				<td>${bbs.NAME }</td>
				<td>${bbs.CRE_DATE }</td>
				<td>${bbs.READCOUNT }</td>
			</tr>
			</c:forEach>
		</table>
		<br>
		<form action="BBS" method="GET" name="search" onsubmit="return Check_search()">
			<select name="SEARCH_TYPE">
				<option value="TOTAL">전체</option>
				<option value="TITLE">제목</option>
				<option value="CONTENTS">내용</option>
				<option value="NAME">작성자</option>
				<option value="TITLE_CONTENTS">제목+내용</option>
			</select>
			<input type="text" name="KEYWORD">
			<input type="submit" value="검색">
			<button type="button" onclick="write_href()">등록</button>
		</form>
		<br>
		
		<ul class="pagination">
		<c:choose>
			<c:when test="${SEARCH_TYPE != null }">
				<c:if test="${(START_PAGENUM/10) > 1 }">
					<li><a href="BBS?PAGENUM=${START_PAGENUM-1 }&SEARCH_TYPE=${SEARCH_TYPE }&KEYWORD=${KEYWORD}">&laquo</a></li>
				</c:if>
				<c:forEach var="i" begin="${START_PAGENUM }" end="${END_PAGENUM }">
					<li><a href="BBS?PAGENUM=${i }&SEARCH_TYPE=${SEARCH_TYPE }&KEYWORD=${KEYWORD}">${i }</a></li>
				</c:forEach>
				<c:if test="${MAX_PAGE > END_PAGENUM }">
					<li><a href="BBS?PAGENUM=${END_PAGENUM+1 }&SEARCH_TYPE=${SEARCH_TYPE }&KEYWORD=${KEYWORD}">&raquo</a></li>
				</c:if>
			</c:when>
			<c:otherwise>
				<c:if test="${(START_PAGENUM/10) > 1 }">
					<li><a href="BBS?PAGENUM=${START_PAGENUM-1 }">&laquo</a></li>
				</c:if>
				<c:forEach var="i" begin="${START_PAGENUM }" end="${END_PAGENUM }">
					<c:choose>
						<c:when test="${PAGENUM == i}">
							<li class="active"><a href="BBS?PAGENUM=${i }">${i }</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="BBS?PAGENUM=${i }">${i }</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:if test="${MAX_PAGE > END_PAGENUM }">
					<li><a href="BBS?PAGENUM=${END_PAGENUM+1 }">&raquo</a><li>
				</c:if>
			</c:otherwise>
		</c:choose>
		</ul>
				
		<br><br>
		
		</div>
		</div> <!-- container -->
</body>
</html>