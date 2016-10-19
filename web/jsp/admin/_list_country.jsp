<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<body>
<form action="controller" method="post">
    <input type="hidden" name="command" value="addcountry">
    <input type="text" name="country" class="form-control"
           placeholder="<fmt:message key="list.country.placeholder.new"/>"
           value="" autofocus="">
    <button class="btn btn-primary" type="submit"><fmt:message key="list.country.btn.add"/></button>
</form>
<table class="table table-striped">
    <thead>
    <tr>
        <th>ID</th>
        <th><fmt:message key="list.country.th.country"/></th>
        <th><fmt:message key="list.country.th.action"/></th>
    </tr>
    </thead>
    <c:forEach var="country" items="${requestScope.countries}">
        <tbody>
        <tr>
            <td>${country.countryId}</td>
            <td>${country.country}</td>
            <td><a class="btn btn-danger"
                   href="controller?command=delcountry&countryId=${country.countryId}"><fmt:message
                    key="list.country.btn.del"/></a></td>
        </tr>
        </tbody>
    </c:forEach>
</table>
</body>
</html>
