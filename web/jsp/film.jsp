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
    <meta name="description" content="">
    <meta name="author" content="">

    <title>${sessionScope.film.title}</title>

    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/style.css" rel="stylesheet">
    <link href="../css/rating.css" rel="stylesheet">
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
                <div class="view-page">
                    <div class="row details">
                        <div class="col-sm-4">
                            <img class="img-responsive" src="images/posters/${sessionScope.film.title}.jpg"
                                 alt="">
                        </div>
                        <div class="col-sm-8">
                            <table class="table-striped table">
                                <tr>
                                    <td><h4><fmt:message key="filmpage.title"/></h4></td>
                                    <td><h4>${sessionScope.film.title}</h4></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="filmpage.year"/></td>
                                    <td>${sessionScope.film.year}</td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="filmpage.genre"/></td>
                                    <td>${sessionScope.film.genre.genre}</td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="filmpage.duration"/></td>
                                    <td>${sessionScope.film.duration}</td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="filmpage.country"/></td>
                                    <td>${sessionScope.film.country.country}</td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="filmpage.director"/></td>
                                    <td>${sessionScope.film.director}</td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="filmpage.actor"/></td>
                                    <td>${sessionScope.film.actor}</td>
                                </tr>
                            </table>

                            <span id="responce"></span>
                            <c:if test="${sessionScope.user.role.roleId == 1}">
                                <a class="btn btn-danger"
                                   href="controller?command=delfilm&filmId=${sessionScope.film.filmId}"
                                   role="button"><fmt:message key="filmpage.btn.delete"/></a>
                                <a class="btn btn-warning"
                                   href="controller?command=goeditpage&filmId=${sessionScope.film.filmId}"
                                   role="button"><fmt:message key="filmpage.btn.edit"/></a>
                                <a class="btn btn-warning"
                                   href="controller?command=goaddpage" role="button"><fmt:message
                                        key="filmpage.btn.add"/></a>
                            </c:if>
                        </div>
                    </div>

                    <h2><fmt:message key="filmpage.about"/></h2>
                    <p>${sessionScope.film.details}</p>
                    <hr/>

                    <div class="form-group embed-responsive embed-responsive-16by9">
                        <iframe class="embed-responsive-item"
                                src="http://www.youtube.com/embed/${sessionScope.film.trailer}" frameborder="0"
                                allowfullscreen></iframe>
                    </div><!--/.youtube frame-->
                    <jsp:include page="elements/_comments.jsp"/>
                </div><!--/.view-page-->
            </div><!--/.col-xs-12.col-sm-9-->
            <jsp:include page="elements/_sideBar.jsp"/>
        </div><!--/row row-offcanvas-->
        <hr>
        <jsp:include page="elements/_footer.jsp"/>
    </div><!--/container-->
    <script src="../js/jquery.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="../js/main.js"></script>
</body>
</html>