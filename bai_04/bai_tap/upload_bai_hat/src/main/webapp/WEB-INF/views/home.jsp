<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 05-May-22
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="baihat" action="/upload" method="post">
    <div>
    Tên bài hát:
    <form:input path ="tenBaiHat"  />
    </div>
    <div>
    Nghệ sĩ thể hiện:
    <form:input path ="ngheSi"  />
    </div>
    <div>
    Thể loại nhạc:
        <form:select path="theLoai">
            <form:option value="Pop"> --Pop--</form:option>
            <form:option value="HipHop"> --HipHop--</form:option>
            <form:option value="Cai Luong"> --Cai Luong--</form:option>
        </form:select>
    </div>
    <div>
        Đường dẫn file bài hát:
        <form:input path ="duongDan"  />
    </div>
    <div>
        <input type="submit" value="upload">
    </div>

</form:form>
</body>
</html>
