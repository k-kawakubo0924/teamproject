<!-- 本ファイルはトップページのJSPです -->

<!-- TODO: 現在は仮の実装です。必要に応じて修正または書き換えてください。 -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ include file="header.jsp" %>  <%-- タイトル + CSS --%>

<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
<!-- 左メニューエリア -->
<div class="menu-wrapper">
<%@ include file="menu.jsp" %>
</div>

    <!-- 右コンテンツエリア -->
<div class="content-container">
<h1>メニュー</h1>
<ul class="menu-list">
<li><a href="<c:url value='#'/>">学生管理</a></li>
</ul>
<h3>成績管理</h3>
<ul class="menu-list">
<li><a href="<c:url value='#'/>">成績登録</a></li>
<li><a href="<c:url value='#'/>">成績参照</a></li>
<li><a href="<c:url value='#'/>">科目管理</a></li>
</ul>
</div>
</div>

<%@ include file="footer.jsp" %>
