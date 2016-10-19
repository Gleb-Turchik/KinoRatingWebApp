<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<select name="country" class="form-control">
    <c:forEach var="country" items="${requestScope.countries}">
        <option value="${country.countryId}">
                ${country.country}
        </option>
    </c:forEach>
</select>
</body>
</html>
