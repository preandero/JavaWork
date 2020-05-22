<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.lec.beans.*"%>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO" />



<%
	WriteDTO[] arr = dao.select();
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>글 목록</title>
<style>
table {
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
	<hr>
	<h2>리스트</h2>
	<table>
		<tr>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>

		<%
			if (arr != null) {
			for (int i = 0; i < arr.length; i++) {
		%>
		<tr>
			<td><%=arr[i].getUid()%></td>
			<td><a href="view.jsp?uid=<%=arr[i].getUid()%>"><%=arr[i].getSubject()%></a></td>
			<td><%=arr[i].getName()%></td>
			<td><%=arr[i].getViewCnt()%></td>
			<td><%=arr[i].getRegDate()%></td>
		</tr>
		<%
			}
		}
		%>

	</table>
	<br>
	<button onclick="location.href='write.jsp'">신규등록</button>

	<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>


	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>















