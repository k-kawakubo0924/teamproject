<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>

<div class="main-container">
    <div class="menu-wrapper">
        <%@ include file="/menu.jsp" %>
    </div>

    <div class="content-container">
        <h1>科目情報登録</h1>

        <form action="SubjectCreateExecute.action" method="post">
            <label for="subjectCode">科目コード</label>
            <input type="text" id="subjectCode" name="cd" placeholder="例：SUB001" required>

            <label for="subjectName">科目名</label>
            <input type="text" id="subjectName" name="name" placeholder="例：英語" required>

            <button type="submit">登録</button>
        </form>
    </div>
</div>

<%@ include file="/footer.jsp" %>
