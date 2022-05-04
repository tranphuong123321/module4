<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 04-May-22
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save">
    <div>
        <h1>Sandwich Condiment</h1>
        <input type="checkbox" id="vehicle1" name="condiment" value="Lettuce">
        <label for="vehicle1">Lettuce</label>
        <input type="checkbox" id="vehicle2" name="condiment" value="Tomato">
        <label for="vehicle1">Tomato</label>
        <input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
        <label for="vehicle1">Mustard</label>
        <input type="checkbox" id="vehicle4" name="condiment" value="Sprouts">
        <label for="vehicle1">Sprouts</label>
    </div>
    <div>
        <input type="submit" value ="save">
    </div>
</form>
</body>
</html>
