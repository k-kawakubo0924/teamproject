<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><!-- 本ファイルはトップページのJSPです -->

<!-- TODO: 現在は仮の実装です。必要に応じて修正または書き換えてください。 -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>  <%-- タイトル + CSS --%>

<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
<!-- 左メニューエリア -->
<div class="menu-wrapper">
<%@ include file="menu.jsp" %>
</div>

    <!-- 右コンテンツエリア -->
<div class="content-container">
<h1>科目管理</h1>
</div>
<ul class="menu-list">
<li><a href="<c:url value='#'/>">新規登録</a></li>
</ul>


<%@ include file="footer.jsp" %>


</body>
</html>