<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 05-May-22
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<form:form modelAttribute="thongtin" action="/save" method="post">
    <div>
        <p style="text-align: center">TỜ KHAI Y TẾ</p>
        <p style="text-align: center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC
            KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</p>
        <p style="text-align: center " color="red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và
            có thể bị xử lý hình sự</p>
    </div>
    <div>
        Họ và tên (viết IN HOA)(*):
        <form:input path="hoTen"/>
    </div>
    <div>
        Năm sinh:
        <form:input path="namSinh"/>
        Giới tính:
        <form:input path="gioiTinh"/>
        Quốc tịch:
        <form:input path="quocTich"/>
    </div>
    <div>
        Số chứng minh nhân dân:
        <form:input path="chungMinh"/>
    </div>
    <div>
        Thông tin đi lại:
        <form:radiobutton path="phuongTien" value="Tàu bay"/>Tàu bay
        <form:radiobutton path="phuongTien" value="Tàu thuyền"/>Tàu thuyền
        <form:radiobutton path="phuongTien" value="Ô tô"/>Ô tô
        <form:radiobutton path="phuongTien" value="Khác"/>Khác
    </div>
    <div>
        Số hiệu phương tiện:
        <form:input path="soHieu"/>
        Số ghê:
        <form:input path="soGhe"/>
    </div>
    <div>
        Ngày khởi hành:
        <form:input path="ngayKhoiHanh"/>
        <form:input path="thangKhoiHanh"/>
        <form:input path="namKhoiHanh"/>
    </div>
    <div>
        Ngày kết thúc:
        <form:input path="ngayKetThuc"/>
        <form:input path="thangKetThuc"/>
        <form:input path="namKetThuc"/>
    </div>
    <div>
    Trong vòng 14 ngày qua anh/chị đã đi đến thành phố nào:
    <form:input path="thanhPho"/>
    </div>
    <div>
        <input type="submit" value="gui to khai">
    </div>
</form:form>
</body>
</html>
