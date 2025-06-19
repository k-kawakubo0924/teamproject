<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>

<div class="main-container">
    <div class="menu-wrapper">
        <%@ include file="/menu.jsp" %>
    </div>

    <div class="content-container">
        <h1>科目情報変更</h1>
        <br>

        <form action="SubjectUpdateExecute.action" method="post">
            <!-- 科目コード（表示のみ、hiddenで送信） -->
            <label>科目コード</label><br>
            <span><c:out value="${subject.cd}" /></span>
            <input type="hidden" name="cd" value="${subject.cd}" />
            <br><br>

            <!-- 科目名（変更可能） -->
            <label for="name">科目名</label><br>
            <input type="text" id="name" name="name" value="${subject.name}" required />
            <br><br>

            <button type="submit">変更</button>
            <a href="SubjectList.action">戻る</a>
        </form>
    </div>
</div>

<%@ include file="/footer.jsp" %>
