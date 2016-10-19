<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<body>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th><fmt:message key="list.comment.th.username"/></th>
        <th><fmt:message key="list.comment.th.film"/> ID</th>
        <th><fmt:message key="list.comment.th.datetime"/></th>
        <th><fmt:message key="list.comment.th.action"/></th>
    </tr>
    </thead>
    <c:forEach var="comment" items="${requestScope.comments}">
        <tbody>
        <tr>
            <td>${comment.commentId}</td>
            <td>${comment.userName}</td>
            <td>${comment.filmId}</td>
            <td>${comment.dateTime}</td>
            <td><a class="btn btn-primary" href="controller?command=getfilm&filmId=${comment.filmId}"><fmt:message
                    key="list.comment.btn.go"/></a></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
