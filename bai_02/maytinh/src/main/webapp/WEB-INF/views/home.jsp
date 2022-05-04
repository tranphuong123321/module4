<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04-May-22
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/result">
    <h1>Caculator</h1>
    <div>
    <input type="text" name="num1">
    <input type="text" name="num2">
    </div><br>
    <div>
    <input type="submit" value="+"  name="operator">
    <input type="submit" value="-" name="operator">
    <input type="submit" value="*" name="operator">
    <input type="submit" value="/" name="operator">
    </div>
</form>
</body>
</html>
