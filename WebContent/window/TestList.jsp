<!-- 本ファイルはトップページのJSPです -->

<!-- TODO: 現在は仮の実装です。必要に応じて修正または書き換えてください。 -->

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
<h1>成績参照</h1>
<div class="search-area">
            <h2>科目情報</h2>
            <label for="year">入学年度</label>
            <select id="year">
                <option value="">----</option>
                <option value="2024">2024</option>
                <option value="2023">2023</option>
            </select>
            <label for="class">クラス</label>
            <select id="class">
                <option value="">----</option>
                <option value="A">A</option>
                <option value="B">B</option>
            </select>
            <label for="subject">科目</label>
            <select id="subject">
                <option value="">----------</option>
                <option value="国語">国語</option>
                <option value="数学">数学</option>
            </select>
            <button class="search-button">検索</button>
        </div>

        <div class="student-info-area">
            <h2>学生情報</h2>
            <label for="studentId">学生番号</label>
            <input type="text" id="studentId" placeholder="学生番号を入力してください">
            <button class="student-search-button">検索</button>
        </div>

        <p class="instruction-text">科目情報を選択または学生情報を入力して検索ボタンをクリックしてください。</p>
    </div>
</div>

<%@ include file="/footer.jsp" %>
