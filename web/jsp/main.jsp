<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="mainpage.title"/></title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="elements/_header.jsp"/>
<div class="container">
    <div class="row row-offcanvas row-offcanvas-right active">
        <div class="col-xs-12 col-sm-9">
            <p class="text-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><fmt:message
                        key="page.btn.toggle"/></button>
            </p>
            <%--<p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
            </p>
            <div class="jumbotron">
                <h1>Welcome to Kino Rating</h1>
                <p>Fell free</p>
            </div>--%>
            <div class="row list">
                <c:forEach var="film" items="${films}">
                    <div class="col-xs-4 col-lg-4 item">
                        <a href="controller?command=getfilm&filmId=${film.filmId}">
                            <img src="images/posters/${film.title}.jpg" alt=""></a>
                        <h3>${film.title}</h3>
                        <p class="desc">${film.details}</p>
                        <a class="btn btn-default" href="controller?command=getfilm&filmId=${film.filmId}"
                           role="button"><fmt:message key="mainpage.btn.more"/> »</a>
                        <c:if test="${sessionScope.user.role.roleId == 1}">
                            <a class="btn btn-danger" href="controller?command=delfilm&filmId=${film.filmId}"
                               role="button"><fmt:message key="mainpage.btn.delete"/></a>
                            <a class="btn btn-warning" href="controller?command=goeditpage&filmId=${film.filmId}"
                               role="button"><fmt:message key="mainpage.btn.edit"/></a>
                        </c:if>
                    </div>
                </c:forEach>
            </div><!--/row list-->
        </div><!--/.col-xs-12.col-sm-9-->
        <jsp:include page="elements/_sideBar.jsp"/>
    </div><!--/row row-offcanvas-->
    <hr>
    <jsp:include page="elements/_footer.jsp"/>
</div><!--/container-->

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
