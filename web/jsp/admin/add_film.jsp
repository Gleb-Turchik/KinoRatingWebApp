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

    <title><fmt:message key="addfilm.title"/></title>

    <!-- Bootstrap core CSS -->
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/style.css" rel="stylesheet">
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
                    <input type="hidden" name="command" value="addfilm">
                    <div class="row details">
                        <div class="col-sm-4">
                            <img class="img-responsive" src="http://placehold.it/290x300" alt="">
                        </div>
                        <div class="col-sm-8">
                            <table class="table-striped table">
                                <tr>
                                    <td><h4><fmt:message key="addfilm.filmtitle"/></h4></td>
                                    <td><h4><input type="text" name="title" class="form-control"
                                                   placeholder="<fmt:message key="addfilm.filmtitle"/>" autofocus=""
                                                   value=""></h4></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="addfilm.year"/></td>
                                    <td><input type="number" name="year" class="form-control"
                                               placeholder="<fmt:message key="addfilm.year"/>"
                                               autofocus="" value=""></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="addfilm.genre"/></td>
                                    <td>
                                        <jsp:include page="../elements/_genre.jsp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="addfilm.duration"/></td>
                                    <td><input type="number" name="duration" class="form-control"
                                               placeholder="<fmt:message key="addfilm.duration"/>" autofocus=""
                                               value=""></td>
                                </tr>
                                <tr>
                                    <td>Страна</td>
                                    <td>
                                        <jsp:include page="../elements/_country.jsp"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="addfilm.director"/></td>
                                    <td><input type="text" name="director" class="form-control"
                                               placeholder="<fmt:message key="addfilm.director"/>" autofocus=""
                                               value=""></td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="addfilm.actor"/></td>
                                    <td><input type="text" name="actor" class="form-control"
                                               placeholder="<fmt:message key="addfilm.actor"/>" autofocus="" value="">
                                    </td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="addfilm.link"/></td>
                                    <td><input type="text" name="trailer" value="" class="form-control"
                                               placeholder="youtube" autofocus=""></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <h2><fmt:message key="addfilm.about"/></h2>
                    <p><textarea name="details" cols="50" rows="6" placeholder="<fmt:message key="addfilm.about"/>"
                                 class="form-control"></textarea></p>
                    <button class="btn btn-success" type="submit"><fmt:message key="addfilm.btn.save"/></button>
                    <a class="btn btn-warning" href="controller?command"><fmt:message key="addfilm.btn.cancel"/></a>
                </form>
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
