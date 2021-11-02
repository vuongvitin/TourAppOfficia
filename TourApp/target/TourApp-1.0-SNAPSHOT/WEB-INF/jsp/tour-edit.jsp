<%-- 
    Document   : tour-edit
    Created on : Oct 12, 2021, 11:14:35 PM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<section>
    <c:if test="${tour.id > 0}">
        <h1 class="text-center text-info">Chỉnh sửa tour</h1>
    </c:if>
    <c:if test="${tour.id  == 0}">
        <h1 class="text-center text-info">Thêm tour</h1> 
    </c:if>
    
    <c:url value="/admin/tour-edit?tourId=${tour.id}" var="action"  />
    <form:form method="post" enctype="multipart/form-data" modelAttribute="tour">
        <form:errors path="*" element="div" class="alert alert-danger" />
        
        <div class="form-group">
            <label for="name">
                Tên chuyến đi:
            </label>
            <form:input type="text" id="name" class="form-control" path="name" />
        </div>
        <div class="form-group">
            <label for="thoiGian">
                Thời gian đi:
            </label>
            <c:if test="${tour.id > 0}">
                <form:input id="thoiGian" class="form-control" path="thoiGian" />
            </c:if>
            <c:if test="${tour.id <= 0}">
                <form:input id="thoiGian" class="form-control" path="thoiGian" />
            </c:if>
        </div>
        <div class="form-group">
            <label for="ngayKhoiHanh">
                Ngày khởi hành("dd-MM-yyyy"):
            </label>
             <form:input id="ngayKhoiHanh" class="form-control" path="ngayKhoiHanh" />
            
        </div>
        <div class="form-group">
            <label for="diemDen">
                Điểm dến:
            </label>
            <c:if test="${tour.id > 0}">
                <form:input id="diemDen" class="form-control" path="diemDen" />
            </c:if>
            <c:if test="${tour.id <= 0}">
                <form:input type="text" id="diemDen" class="form-control" path="diemDen" />
            </c:if>
        </div>
        <div class="form-group">
            <label for="phuongTien">
                Phương tiện:
            </label>
            <c:if test="${tour.id > 0}">
                <form:input id="phuongTien" class="form-control" path="phuongTien" />
            </c:if>
            <c:if test="${tour.id <= 0}">
                <form:input type="text" id="phuongTien" class="form-control" path="phuongTien" />
            </c:if>
        </div>
        <div class="form-group">
            <label for="image">
                Ảnh chủ đề:
            </label>
                 <form:input type="file" id="image" path = "file" class="form-control" />
        </div>
        <div class="form-group">
            <label for="mota">
                Mô tả:
            </label>
            <c:if test="${tour.id > 0}">
                <form:input id="mota" class="form-control" path="mota" />
            </c:if>
            <c:if test="${tour.id <= 0}">
                <form:input type="text" id="mota" class="form-control" path="mota" />
            </c:if>
        </div>
        <div class="form-group">
            <label for="giaTour">
                Giá:
            </label>
            <c:if test="${tour.id > 0}">
                <form:input id="giaTour" class="form-control" path="giaTour" />
            </c:if>
            <c:if test="${tour.id <= 0}">
                <form:input type="text" id="giaTour" class="form-control" path="giaTour" />
            </c:if>
        </div>
        <div class="form-group">
            <label for="diemKhoiHanh">
                Nơi khởi hành:
            </label>
            <c:if test="${tour.id > 0}">
                <form:input id="diemKhoiHanh" class="form-control" path="diemKhoiHanh" />
            </c:if>
            <c:if test="${tour.id <= 0}">
                <form:input type="text" id="diemKhoiHanh" class="form-control" path="diemKhoiHanh" />
            </c:if>
        </div>
        <form:select class="form-control" id="type" path="typeId">
                 <c:forEach items="${types}" var="type">
                    <c:if test="${type.id == tour.typeId.id}">
                        <option selected value="${type.id}">${type.ten}</option>
                    </c:if>
                    <c:if test="${type.id != tour.typeId.id}">
                        <option value="${type.id}">${type.ten}</option>
                    </c:if>
                </c:forEach>
        </form:select>    
                        <br>
        <div class="form-group">
            <c:if test="${tour.id > 0}">
                <input type="submit" class="btn btn-warning" 
                   value="Cập nhật" />
            </c:if>
            <c:if test="${tour.id <= 0}">
                <input type="submit" class="btn btn-success" 
                   value="Thêm tour" /> 
            </c:if>
        </div>
    </form:form>
</section>