<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="editfilm.title"/></title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<jsp:include page="../elements/_header.jsp"/>
<div class="container">
    <div class="row row-offcanvas row-offcanvas-right active">
        <div class="col-xs-12 col-sm-9">
            <p class="text-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><fmt:message
                        key="page.btn.toggle"/></button>
            </p>
            <div class="view-page">
                <form action="controller" method="post">
                    <input type="hidden" name="command" value="editfilm">
                    <input type="hidden" name="filmId" value="${sessionScope.film.filmId}">
                    <div class="row details">
                        <div class="col-sm-4">
                            <img class="img-responsive"
                                 src="../../images/posters/${sessionScope.film.title}.jpg" alt="">
                        </div>
                        <div class="col-sm-8">
                            <table class="table-striped table">
                                <tr>
                                    <td><h4><fmt:message key="editfilm.filmtitle"/></h4></td>
                                    <td><h4><input type="text" name="title" class="form-control"
                                                   value="${sessionScope.film.title}" autofocus="" maxlength="25"></h4></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editfilm.year"/></td>
                                    <td><input type="number" min="1900" maxlength="2016" pattern="\d+" name="year" class="form-control"
                                               value="${sessionScope.film.year}" autofocus=""></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editfilm.genre"/></td>
                                    <td>
                                        <jsp:include page="../elements/_genre.jsp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editfilm.duration"/></td>
                                    <td><input type="number" min="5" maxlength="200" pattern="\d+" name="duration" class="form-control"
                                               value="${sessionScope.film.duration}" autofocus=""></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editfilm.country"/></td>
                                    <td>
                                        <jsp:include page="../elements/_country.jsp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editfilm.director"/></td>
                                    <td><input type="text" name="director" class="form-control"
                                               value="${sessionScope.film.director}" autofocus="" maxlength="50"></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editfilm.actor"/></td>
                                    <td><input type="text" name="actor" class="form-control"
                                               value="${sessionScope.film.actor}" autofocus="" maxlength="50"></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editfilm.link"/></td>
                                    <td><input type="text" name="trailer" class="form-control"
                                               value="${sessionScope.film.trailer}" autofocus="" maxlength="15">
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <h2><fmt:message key="editfilm.about"/></h2>
                    <p><textarea name="details" cols="50" rows="6" maxlength="350"
                                 class="form-control">${sessionScope.film.details}</textarea></p>
                    <button class="btn btn-success" type="submit"><fmt:message key="editfilm.btn.save"/></button>
                    <a class="btn btn-warning"
                       href="controller?command=getfilm&filmId=${sessionScope.film.filmId}"><fmt:message
                            key="editfilm.btn.cancel"/></a>
                </form>
                <jsp:include page="../elements/_comments.jsp"/>
            </div>
        </div>
        <jsp:include page="../elements/_sideBar.jsp"/>
    </div>
    <hr>
    <jsp:include page="../elements/_footer.jsp"/>
</div>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/main.js"></script>
</body>
</html>
