<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="addgenre">
    <input type="text" name="genre" class="form-control" placeholder="<fmt:message key="list.genre.placeholder.new"/>"
           value="" autofocus="">
    <button class="btn btn-primary" type="submit"><fmt:message key="list.genre.btn.add"/></button>
</form>
<hr/>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th><fmt:message key="list.genre.th.genre"/></th>
        <th><fmt:message key="list.genre.th.action"/></th>
    </tr>
    </thead>
    <c:forEach var="genre" items="${requestScope.genres}">
        <tbody>
        <tr>
            <td>${genre.genreId}</td>
            <td>${genre.genre}</td>
            <td><a class="btn btn-danger" href="controller?command=delgenre&genreId=${genre.genreId}"><fmt:message
                    key="list.genre.btn.del"/></a></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
