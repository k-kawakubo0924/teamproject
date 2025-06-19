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
    <h1>科目管理</h1>

    <!-- 新規登録リンク -->
    <ul class="menu-list">
      <li><a href="<c:url value='SubjectCreate.action'/>">新規登録</a></li>
    </ul>

    <!-- 科目一覧表示テーブル -->
    <c:choose>
      <c:when test="${not empty subjectList}">
        <table border="1">
          <thead>
            <tr>
              <th>科目コード</th>
              <th>科目名</th>
              <th>変更</th>
              <th>削除</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="subject" items="${subjectList}">
              <tr>
                <td>${subject.cd}</td>
                <td>${subject.name}</td>
			<td><a href="<c:url value='SubjectUpdate.action'><c:param name='cd' value='${subject.cd}'/></c:url>">変更</a></td>
            <td><a href="<c:url value='SubjectDelete.action'><c:param name='cd' value='${subject.cd}'/></c:url>">削除</a></td>              </tr>
            </c:forEach>
          </tbody>
        </table>
      </c:when>
      <c:otherwise>
        <p>登録されている科目はありません。</p>
      </c:otherwise>
    </c:choose>
  </div>

</div>

<%@ include file="/footer.jsp" %>
