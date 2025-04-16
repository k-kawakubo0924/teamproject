<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/header.jsp" %> <%-- タイトル + CSS --%>

<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
    <!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="/menu.jsp" %>
    </div>

    <!-- 右コンテンツエリア -->
    <div class="content-container">
        <h1>学生情報変更</h1>
        <br>

        <!-- 学生情報変更フォーム -->
        <form action="StudentUpdateServlet" method="post" class="student-form">
            <label for="admissionYear">入学年度</label><br>
            <input type="text" id="admissionYear" name="admissionYear" value="${student.admissionYear}" readonly><br><br>

            <label for="studentId">学生番号</label><br>
            <input type="text" id="studentId" name="studentId" value="${student.studentId}" readonly><br><br>

            <label for="name">氏名</label><br>
            <input type="text" id="name" name="name" value="${student.name}"><br><br>

            <label for="class">クラス</label><br>
            <select name="class" id="class">

            </select><br><br>

            <label>
                <input type="checkbox" name="isEnrolled" value="true" <c:if test="${student.isEnrolled}">checked</c:if>> 在学中
            </label><br><br>

            <button type="submit">変更</button>
            <a href="index.jsp">戻る</a>
        </form>
    </div>
</div>

<%@ include file="/footer.jsp" %>
