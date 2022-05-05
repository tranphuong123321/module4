<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 05-May-22
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/update">
    <h1>Settings</h1>
    <span style="color: green">${mess}</span>
    <form:form modelAttribute="homthu" action="/update" method="post">
    <div>
        Languages:
        <form:select path="languages">
            <form:option value="English"> --English--</form:option>
            <form:option value="Vietnamese"> --Vietnamese--</form:option>
            <form:option value="Japanese"> --Japanese--</form:option>
            <form:option value="Chinese"> --Chinese--</form:option>
        </form:select>
    </div>
    <div>
        Pages size:
        <form:select path="pageSize">
            <form:option value="5"> --5--</form:option>
            <form:option value="10"> --10--</form:option>
            <form:option value="15"> --15--</form:option>
            <form:option value="25"> --25--</form:option>
            <form:option value="50"> --50--</form:option>
            <form:option value="100"> --100--</form:option>
        </form:select>
        email per page
    </div>
    <div>
        Spams fillter:
        <form:checkbox path="spamFillter"/> Enable spams fillter
    </div>
    <div>
        Signatue:
        <form:textarea path="signature" id="signature"/>
    </div>
    <div>
        <input type="submit" value="update">
        <input type="submit" value="cancel">
    </div>
    </form:form>
</body>
</html>
