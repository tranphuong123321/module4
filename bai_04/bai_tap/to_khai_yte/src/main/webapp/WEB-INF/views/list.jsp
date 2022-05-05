<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 05-May-22
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>TỜ KHAI Y TẾ</h1>
<a href="/home">edit</a>
<c:forEach items="${thongtinList}" var="thongtin">
${thongtin.hoTen}
${thongtin.namSinh}
${thongtin.gioiTinh}
${thongtin.quocTich}
${thongtin.chungMinh}
${thongtin.phuongTien}
${thongtin.soHieu}
${thongtin.soGhe}
${thongtin.ngayKhoiHanh}
${thongtin.thangKhoiHanh}
${thongtin.namKhoiHanh}
${thongtin.ngayKetThuc}
${thongtin.thangKetThuc}
${thongtin.namKetThuc}
${thongtin.thanhPho}
</c:forEach>
</body>
</html>
