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
        <th><fmt:message key="list.film.th.title"/></th>
        <th><fmt:message key="list.film.th.duration"/></th>
        <th><fmt:message key="list.film.th.genre"/></th>
        <th><fmt:message key="list.film.th.country"/></th>
        <th><fmt:message key="list.film.th.action"/></th>
    </tr>
    </thead>
    <c:forEach var="film" items="${requestScope.films}">
        <tbody>
        <tr>
            <td>${film.filmId}</td>
            <td>${film.title}</td>
            <td>${film.duration}</td>
            <td>${film.genre}</td>
            <td>${film.country}</td>
            <td><a class="btn btn-primary" href="controller?command=getfilm&filmId=${film.filmId}"><fmt:message
                    key="list.film.btn.go"/></a></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
