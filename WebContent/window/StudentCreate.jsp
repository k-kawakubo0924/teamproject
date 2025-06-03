<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/header.jsp" %>
<%@ page import="java.util.Map, java.util.HashMap" %>

<%
    String admissionYear = request.getParameter("admission_year");
    String studentNumber = request.getParameter("student_number");
    String name = request.getParameter("name");
    String className = request.getParameter("class");

    boolean submitted = "POST".equalsIgnoreCase(request.getMethod());
    Map<String, String> errors = new HashMap<>();

    if (submitted) {
        if (admissionYear == null || admissionYear.isEmpty()) {
            errors.put("admission_year", "入学年度を選択してください");
        }

        if (studentNumber == null || studentNumber.trim().isEmpty()) {
            errors.put("student_number", "学生番号を入力してください");
        } else if ("2231111".equals(studentNumber.trim())) {
            errors.put("student_number_duplicate", "学生番号が重複しています");
        }

        if (name == null || name.trim().isEmpty()) {
            errors.put("name", "氏名を入力してください");
        }
    }
%>

<!-- メニューとコンテンツを横並びに配置するコンテナ -->
<div class="main-container">
    <!-- 左メニューエリア -->
    <div class="menu-wrapper">
        <%@ include file="/menu.jsp" %>
    </div>

    <!-- 右コンテンツエリア -->
    <div class="content-container">
        <h1>学生情報登録</h1>

<% if (submitted && errors.isEmpty()) { %>
	<p><%= "DEBUG: studentNumber=" + studentNumber %></p>
<%
    // ここで Student オブジェクトを作成して DAO に渡す
} else {
%>            <form action="StudentCreate.action" method="post">
                <label for="admission_year">入学年度</label><br>
                <select id="admission_year" name="admission_year">
                    <option value="">---------</option>
                    <option value="2023" <%= "2023".equals(admissionYear) ? "selected" : "" %>>2023</option>
                    <option value="2024" <%= "2024".equals(admissionYear) ? "selected" : "" %>>2024</option>
                    <option value="2025" <%= "2025".equals(admissionYear) ? "selected" : "" %>>2025</option>
                </select><br>
                <% if (errors.get("admission_year") != null) { %>
                    <span style="color: orange;">① <%= errors.get("admission_year") %></span><br>
                <% } %>
                <br>

                <label for="student_number">学生番号</label><br>
                <input type="text" id="student_number" name="student_number"
                       value="<%= studentNumber != null ? studentNumber : "" %>"
                       placeholder="学生番号を入力してください"><br>
                <% if (errors.get("student_number") != null) { %>
                    <span style="color: red;">このフィールドを入力してください。</span><br>
                <% } else if (errors.get("student_number_duplicate") != null) { %>
                    <span style="color: orange;">② <%= errors.get("student_number_duplicate") %></span><br>
                <% } %>
                <br>

                <label for="name">氏名</label><br>
                <input type="text" id="name" name="name"
                       value="<%= name != null ? name : "" %>"
                       placeholder="氏名を入力してください"><br>
                <% if (errors.get("name") != null) { %>
                    <span style="color: red;">このフィールドを入力してください。</span><br>
                <% } %>
                <br>

                <label for="class">クラス</label><br>
                <select id="class" name="class">
                    <option value="101" <%= "101".equals(className) ? "selected" : "" %>>101</option>
                    <option value="102" <%= "102".equals(className) ? "selected" : "" %>>102</option>
                    <option value="103" <%= "103".equals(className) ? "selected" : "" %>>103</option>
                </select><br><br>

                <button type="submit">登録して終了</button>
            </form>
        <% } %>

        <br>
        <div>
            <a href="../index.jsp">戻る</a>
        </div>
    </div>
</div>

<%@ include file="/footer.jsp" %>
