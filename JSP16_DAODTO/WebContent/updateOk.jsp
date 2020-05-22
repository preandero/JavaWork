<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.lec.beans.*" %>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/>
<%
	request.setCharacterEncoding("utf-8");
	int uid = Integer.parseInt(request.getParameter("uid"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");

%>

<%
		int cnt = dao.update(uid, subject, content);
%>


<% if(cnt == 0){ %>
		<script>
			alert("수정 실패!!!!!!");
			history.back();   // 브라우저가 기억하는 직전 페이지(입력중 페이지로)
		</script>
<% } else { %>
		<script>
			alert("수정 성공");
			location.href = "view.jsp?uid=<%= uid %>";
		</script>

<% } %>