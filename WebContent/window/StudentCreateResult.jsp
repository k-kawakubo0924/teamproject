<!-- TODO: 現在は仮の実装です。必要に応じて修正または書き換えてください。 -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>

<div class="main-container">
    <!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="../menu.jsp" %>
    </div>

    <!-- 右コンテンツエリア -->
    <div class="content-container">
    <h2>学生情報登録</h2>
        <h3>登録が完了しました</h3>

        <a href="/index.jsp">Topページへ</a>
    </div>
</div>

<%@ include file="/footer.jsp" %>
