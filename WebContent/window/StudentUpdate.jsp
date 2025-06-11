<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Map, java.util.HashMap" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/header.jsp" %>

<%
    // 入力パラメータ取得
    String admissionYear = (String)request.getAttribute("admissionYear");
    String studentId = (String)request.getAttribute("studentId");
    String name = request.getParameter("name");
    String className = request.getParameter("class");
    String isEnrolled = request.getParameter("isEnrolled");

    boolean submitted = "POST".equalsIgnoreCase(request.getMethod());
    Map<String, String> errors = new HashMap<>();

    if (submitted) {
        if (admissionYear == null || admissionYear.isEmpty()) {
            errors.put("admissionYear", "入学年度を選択してください。");
        }
        if (studentId == null || studentId.trim().isEmpty()) {
            errors.put("studentId", "学生番号を入力してください。");
        }
        if (name == null || name.trim().isEmpty()) {
            errors.put("name", "氏名を入力してください。");
        }
        if (className == null || className.isEmpty()) {
            errors.put("class", "クラスを選択してください。");
        }
    }
%>

<div class="main-container">
    <div class="menu-wrapper">
        <%@ include file="/menu.jsp" %>
    </div>

    <div class="content-container">
        <h1>学生情報変更</h1>
        <br>

        <% if (submitted && errors.isEmpty()) { %>
            <p style="color: green;">変更が完了しました。</p>
        <% } else { %>
            <form action="StudentUpdateExecute.action" method="post" class="student-form">
                <label>入学年度</label><br>
<span><c:out value="${student.entYear}" /></span>
<input type="hidden" name="admissionYear" value="${student.entYear}" />            <br>
                <% if (errors.get("admissionYear") != null) { %>
                    <span style="color: red;"><%= errors.get("admissionYear") %></span><br>
                <% } %>
                <br>

                <label>学生番号</label><br>
<span><c:out value="${student.no}" /></span>
<input type="hidden" name="no" value="${student.no}" />                <br>

                <label for="name">氏名</label><br>
                <input type="text" id="name" name="name"
                       value="<%= name != null ? name : "" %>"><br>
                <% if (errors.get("name") != null) { %>
                    <span style="color: red;"><%= errors.get("name") %></span><br>
                <% } %>
                <br>

                <label for="class">クラス</label><br>
                <select name="class" id="class_num">
                    <option value="">選択してください</option>
                    <option value="101" <%= "101".equals(className) ? "selected" : "" %>>101</option>
                    <option value="102" <%= "102".equals(className) ? "selected" : "" %>>102</option>
                    <option value="103" <%= "103".equals(className) ? "selected" : "" %>>103</option>
                </select><br>
                <% if (errors.get("class") != null) { %>
                    <span style="color: red;"><%= errors.get("class") %></span><br>
                <% } %>
                <br>

                <label>
                    <input type="checkbox" name="is_attend" value="true"
                        <%= "true".equals(isEnrolled) ? "checked" : "" %>> 在学中
                </label><br><br>

				<button type="submit">変更</button>
                <a href="StudentList.action">戻る</a>
            </form>
        <% } %>
    </div>
</div>

<%@ include file="/footer.jsp" %>