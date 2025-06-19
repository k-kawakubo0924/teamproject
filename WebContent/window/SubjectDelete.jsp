<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>

<div class="main-container">
    <div class="menu-wrapper">
        <%@ include file="/menu.jsp" %>
    </div>

    <div class="content-container">
        <h1>科目情報削除</h1>

        <p>「${subject.name}（${subject.cd}）」を削除してもよろしいですか</p>

        <!-- 削除実行Actionに送信 -->
        <form action="SubjectDeleteExecute.action" method="post">
            <!-- DAOのSubjectクラスのcdフィールドを使う前提でnameはcdに -->
            <input type="hidden" name="cd" value="${subject.cd}" />
            <button type="submit">削除する</button>
        </form>

        <a href="SubjectList.action">戻る</a>
    </div>
</div>
