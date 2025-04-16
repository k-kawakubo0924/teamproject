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
        <h1>科目情報登録</h1>

        <div class="search-area">
            <h2>新規科目の登録</h2>

            <!-- 登録フォーム -->
            <form action="SubjectRegisterServlet" method="post">
                <label for="subjectCode">科目コード</label>
                <input type="text" id="subjectCode" name="subjectCode" placeholder="例：SUB001" required>

                <label for="subjectName">科目名</label>
                <input type="text" id="subjectName" name="subjectName" placeholder="例：英語" required>

                <button type="submit" class="search-button">登録</button>
            </form>
        </div>

        <p class="instruction-text">科目コードと科目名を入力して登録ボタンをクリックしてください。</p>
    </div>
</div>

<%@ include file="/footer.jsp" %>

