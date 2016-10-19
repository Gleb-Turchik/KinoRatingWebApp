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
        <th><fmt:message key="list.user.th.name"/></th>
        <th><fmt:message key="list.user.th.surname"/></th>
        <th><fmt:message key="list.user.th.email"/></th>
        <th><fmt:message key="list.user.th.role"/></th>
        <th><fmt:message key="list.user.th.status"/></th>
        <th><fmt:message key="list.user.th.action"/></th>
    </tr>
    </thead>
    <c:forEach var="user" items="${requestScope.users}">
        <tbody>
        <tr>
            <td>${user.userId}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.email}</td>
            <td>${user.role.role}</td>
            <td>${user.baned}</td>
            <td><a class="btn btn-danger" href="controller?command=banuser&userId=${user.userId}"><fmt:message
                    key="list.user.btn.ban"/></a>
                <a class="btn btn-primary" href="controller?command=unbanuser&userId=${user.userId}"><fmt:message
                        key="list.user.btn.removeban"/></a></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
