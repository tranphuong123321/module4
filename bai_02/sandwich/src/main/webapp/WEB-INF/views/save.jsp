<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04-May-22
  Time: 11:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>Sandwich Condiment</h1>
    <c:forEach var="sandwich" items="${condiment}">
        <c:out value = "${sandwich}"/>
    </c:forEach>

</div>
</body>
</html>
