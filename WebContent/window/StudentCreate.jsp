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
        <h1>学生情報登録</h1>

        <form action="registerStudent.jsp" method="post">
            <label for="admission_year">入学年度</label><br>
            <select id="admission_year" name="admission_year">
                <option value="">---------</option>
                <option value="2023">2023</option>
                <option value="2024">2024</option>
                <option value="2025">2025</option>
            </select><br><br>

            <label for="student_number">学生番号</label><br>
            <input type="text" id="student_number" name="student_number" placeholder="学生番号を入力してください"><br><br>

            <label for="name">氏名</label><br>
            <input type="text" id="name" name="name" placeholder="氏名を入力してください"><br><br>

            <label for="class">クラス</label><br>
            <select id="class" name="class">
                <option value="101">101</option>
                <option value="102">102</option>
                <option value="103">103</option>
            </select><br><br>

            <button type="submit">登録して終了</button>
        </form>

        <br>
        <div>
        <a href="index.jsp">戻る</a>
        </div>
    </div>
</div>

<%@ include file="/footer.jsp" %>
