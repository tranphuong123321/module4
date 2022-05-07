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
    <div>
        Họ và tên:
            ${thongtin.hoTen}
    </div>
    <div>
        Năm sinh:
            ${thongtin.namSinh}
    </div>
    <div>
        Giới tính:
            ${thongtin.gioiTinh}
    </div>
    <div>
        Quốc tịch
            ${thongtin.quocTich}
    </div>
    <div>
        Số chứng minh nhân dân:
            ${thongtin.chungMinh}
    </div>
    <div>
        Phương tiện di chuyển
            ${thongtin.phuongTien}
    </div>
    <div>
        Số hiệu
            ${thongtin.soHieu}
    </div>
    <div>
        Số ghế:
            ${thongtin.soGhe}
    </div>
    <div>
        Ngày khởi hành:
            ${thongtin.ngayKhoiHanh}

            ${thongtin.thangKhoiHanh}

            ${thongtin.namKhoiHanh}
    </div>
    <div>
        Ngày kết thúc:
            ${thongtin.ngayKetThuc}
            ${thongtin.thangKetThuc}
            ${thongtin.namKetThuc}
    </div>
    <div>
        Trong 14 ngày qua anh/chị đã đi đến đâu:
            ${thongtin.thanhPho}
    </div>
</c:forEach>
</body>
</html>
