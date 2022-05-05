<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 05-May-22
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach bai hat</h1>
<div>
<h2><a href="/home" >back home</a></h2>
</div><br>
<c:forEach var="baihat" items="${listBaiHat}">
    <div>
        <span style="font-weight: bold">Ten bai hat:</span>
            ${baihat.tenBaiHat}
    </div>
    <div>
        Ten nghe si:
            ${baihat.ngheSi}
    </div>
    <div>
        The loai:
        ${baihat.theLoai}
    </div>
    <div>
        Duong dan:
        <a href="/${baihat.duongDan}">  ${baihat.duongDan}</a>
    </div>
</c:forEach>


</body>
</html>
