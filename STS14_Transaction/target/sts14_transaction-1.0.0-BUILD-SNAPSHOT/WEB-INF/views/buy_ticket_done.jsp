<%--
  Created by IntelliJ IDEA.
  User: suu
  Date: 2020/06/30
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>구매 완료</title>
</head>
<body>
<p>결제 완료</p>
고객 아이디 : ${ticketInfo.userId } <br />
티켓 구매수 : ${ticketInfo.ticketCount } <br />
<button onclick="history.back()">돌아가기</button>
</body>
</html>

