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
        <h1>科目情報削除</h1>

        <p>「${subject.name}」を削除してもよろしいですか？</p>

        <form action="DeleteSubjectServlet" method="post">
            <input type="hidden" name="subjectId" value="${subject.id}" />
            <button type="submit">削除する</button>
        </form>

        <a href="../index.jsp">戻る</a>
		</div>

        </div>
