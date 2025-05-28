<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>  <%-- タイトル + CSS --%>

<div class="main-container">
    <!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="../menu.jsp" %>
    </div>

    <!-- 右コンテンツエリア -->
    <div class="content-container">
    <h2>科目情報登録</h2>
        <h3>登録が完了しました</h3>

        <a href="../index.jsp">Topページへ</a>
    </div>
</div>

<%@ include file="../footer.jsp" %>
