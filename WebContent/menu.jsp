<!-- 本ファイルはメニューエリアを表示する JSP です。 -->

<!-- TODO: 現在は仮の実装です。必要に応じて修正または書き換えてください。 -->

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- 左メニューエリア -->
<div class="menu-container">
	<li><a href="<c:url value='/index.jsp'/>">メニュー</a></li>
	<ul class="menu-list">
		<li><a href="<c:url value='/window/StudentList.jsp'/>">学生管理</a></li>
	</ul>
	<h3>成績管理</h3>
	<ul class="menu-list">
		<li><a href="<c:url value='#'/>">成績登録</a></li>
		<li><a href="<c:url value='#'/>">成績参照</a></li>
	</ul>
	<ul class="menu-list">
	<li><a href="<c:url value='#'/>">科目管理</a></li>
	</ul>
</div>
