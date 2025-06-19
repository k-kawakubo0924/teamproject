<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>

<body>
<div class="login-container">
    <h2>ログイン</h2>

    <!-- エラーメッセージ表示 -->
    <c:if test="${not empty errorMsg}">
        <p style="color:red;">${errorMsg}</p>
    </c:if>

    <!-- フォーム開始：.actionを使いFrontControllerに渡す -->
	<form action="${pageContext.request.contextPath}/scoremanager/LoginExecute.action" method="post">
    	<label for="id">ID:</label>
    	<input type="text" name="id" id="id"><br>

    	<label for="password">Password:</label>
    	<input type="password" name="password" id="password"><br>

    	<input type="submit" value="ログイン">
	</form>
</div>
</body>

<%@ include file="/footer.jsp" %>
