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
        <h1>成績管理</h1>
        <br>

        <!-- 絞り込みフォーム -->
        <form action="GradeSearchServlet" method="get" class="filter-form">
            <!-- 入学年度 -->
            <label for="admissionYear">入学年度</label>
            <select name="admissionYear" id="admissionYear">
                <option value="">------</option>
                <c:forEach var="year" items="${admissionYearList}">
                    <option value="${year}" <c:if test="${year == param.admissionYear}">selected</c:if>>${year}</option>
                </c:forEach>
            </select>

            <!-- クラス -->
            <label for="class">クラス</label>
            <select name="class" id="class">
                <option value="">------</option>

            </select>

            <!-- 科目 -->
            <label for="subject">科目</label>
            <select name="subject" id="subject">
                <option value="">------</option>
                <c:forEach var="subj" items="${subjectList}">
                    <option value="${subj}" <c:if test="${subj == param.subject}">selected</c:if>>${subj}</option>
                </c:forEach>
            </select>

            <!-- 回数 -->
            <label for="examNumber">回数</label>
            <select name="examNumber" id="examNumber">
                <option value="">------</option>
                <c:forEach var="num" items="${examCountList}">
                    <option value="${num}" <c:if test="${num == param.examNumber}">selected</c:if>>${num}</option>
                </c:forEach>
            </select>

            <!-- 絞り込みボタン -->
            <button type="submit">検索</button>
        </form>

        <br>
        <a href="../index.jsp">戻る</a>
    </div>
</div>

<%@ include file="/footer.jsp" %>

