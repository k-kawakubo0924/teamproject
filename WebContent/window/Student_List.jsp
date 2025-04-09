<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="/header.jsp" %> <%-- タイトル + CSS --%>

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
        <a href="index.jsp">戻る</a>
    </div>
</div>

<%@ include file="/footer.jsp" %>
