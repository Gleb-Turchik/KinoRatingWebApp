<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<body>
<div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
    <div class="list-group">
        <a href="controller?command=searchByGenre&genre=1" class="list-group-item"><fmt:message
                key="sidebar.action"/></a>
        <a href="controller?command=searchByGenre&genre=2" class="list-group-item"><fmt:message
                key="sidebar.comedy"/></a>
        <a href="controller?command=searchByGenre&genre=3" class="list-group-item"><fmt:message
                key="sidebar.drama"/></a>
        <a href="controller?command=searchByGenre&genre=4" class="list-group-item"><fmt:message
                key="sidebar.fantasy"/></a>
        <a href="controller?command=searchByGenre&genre=5" class="list-group-item"><fmt:message
                key="sidebar.adventure"/></a>
        <a href="controller?command=searchByGenre&genre=6" class="list-group-item"><fmt:message
                key="sidebar.soap"/></a>
        <a href="controller?command=searchByGenre&genre=7" class="list-group-item"><fmt:message
                key="sidebar.thriller"/></a>
        <a href="controller?command=searchByGenre&genre=8" class="list-group-item"><fmt:message
                key="sidebar.horror"/></a>
        <a href="controller?command=searchByGenre&genre=9" class="list-group-item"><fmt:message
                key="sidebar.detective"/></a>
        <a href="controller?command=searchByGenre&genre=10" class="list-group-item"><fmt:message
                key="sidebar.historical"/></a>
        <a href="controller?command=searchByGenre&genre=11" class="list-group-item"><fmt:message
                key="sidebar.cartoon"/></a>
        <a href="controller?command=searchByGenre&genre=12" class="list-group-item"><fmt:message
                key="sidebar.documentary"/></a>
        <a href="controller?command=searchRandom" class="list-group-item"><fmt:message key="sidebar.random"/></a>
    </div>
</div>
</body>
</html>
