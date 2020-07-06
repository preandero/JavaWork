<%--
  Created by IntelliJ IDEA.
  User: suu
  Date: 2020/07/06
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Access Denied Page</title>
</head>
<body>
<h1>Access Denied Page</h1>
<h2><c:out value="${SPRING_SECURITY_403_EXCEPTION.getMessage()}"/></h2>
<h2><c:out value="${msg}"/> </h2>

</body>
</html>
