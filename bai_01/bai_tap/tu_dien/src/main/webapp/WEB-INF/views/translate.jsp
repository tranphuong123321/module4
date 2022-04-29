<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 29-Apr-22
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>

    <c:if test="${result eq null}">
        ket qua: ${text}= ko co trong tu dien
    </c:if>
    <c:if test="${result != null}">
        ket qua: ${text} =  ${result}
    </c:if>

</h1>
</body>
</html>
