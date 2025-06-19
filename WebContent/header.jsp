<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />">
</head>

<body>
    <!-- ヘッダーエリア -->
    <div class="header-wrapper">
        <h1>得点管理システム</h1>

        <ul class="logout">
            <!-- ログイン後、セッションにteacherがあればIDを表示 -->
            <c:if test="${not empty sessionScope.teacher}">
                <li>ID: <c:out value="${sessionScope.teacher.id}" /></li>
            </c:if>
            <li><a href="<c:url value='/window/Login.jsp' />">ログイン</a></li>
            <li><a href="<c:url value='/window/Logout.jsp' />">ログアウト</a></li>
        </ul>
    </div>
</body>
</html>
