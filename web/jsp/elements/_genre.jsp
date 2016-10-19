<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<select name="genre" class="form-control">
    <c:forEach var="genre" items="${requestScope.genres}">
        <option value="${genre.genreId}">
                ${genre.genre}
        </option>
    </c:forEach>
</select>
</body>
</html>
