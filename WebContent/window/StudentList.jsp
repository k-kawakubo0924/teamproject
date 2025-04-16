<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>  <%-- タイトル + CSS --%>

<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
    <!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="/menu.jsp" %>
    </div>

    <!-- 右コンテンツエリア -->
    <div class="content-container">
        <h1>学生管理</h1>
        <br>

        <!-- 絞り込みフォーム -->
        <form action="StudentSearchServlet" method="get" class="filter-form">
            <label for="admissionYear">入学年度</label>
            <select name="admissionYear" id="admissionYear">
                <option value="">------</option>
                <c:forEach var="year" items="${admissionYearList}">
                    <option value="${year}" <c:if test="${year == param.admissionYear}">selected</c:if>>${year}</option>
                </c:forEach>
            </select>

            <label for="class">クラス</label>
            <select name="class" id="class">
                <option value="">------</option>

            </select>

            <label>
                <input type="checkbox" name="isEnrolled" value="true" <c:if test="${param.isEnrolled == 'true'}">checked</c:if>> 在学中
            </label>

            <button type="submit">絞込み</button>
            <a href="StudentRegister.jsp" class="register-link">新規登録</a>
        </form>

        <br>
        <a href="index.jsp">戻る</a>
    </div>
</div>

<%@ include file="/footer.jsp" %>
