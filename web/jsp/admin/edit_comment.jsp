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

    <title><fmt:message key="editcomment.title"/></title>

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
                    <input type="hidden" name="command" value="editcomment">
                    <input type="hidden" name="commentId" value="${sessionScope.comment.commentId}">
                    <input type="hidden" name="filmId" value="${sessionScope.comment.filmId}">
                    <div class="row details">
                        <div class="col-sm-4">
                            <img class="img-responsive"
                                 src="../../images/avatar/${sessionScope.comment.userId}/avaBig.jpg" alt="">
                        </div>
                        <div class="col-sm-8">
                            <table class="table-striped table">
                                <tr>
                                    <td><fmt:message key="editcomment.username"/> - (ID)</td>
                                    <td>${sessionScope.comment.userName} (ID - ${sessionScope.comment.userId})</td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editcomment.filmtitle"/> - (ID)</td>
                                    <td>${sessionScope.film.title} (ID - ${sessionScope.comment.filmId})</td>
                                </tr>
                                <tr>
                                    <td><fmt:message key="editcomment.date"/></td>
                                    <td>${sessionScope.comment.dateTime}</td>
                                </tr>
                            </table>
                            <h2><fmt:message key="editcomment.comment"/></h2>
                            <p><textarea name="text" id="text" cols="25" rows="5" placeholder="Text"
                                         class="form-control">${sessionScope.comment.text}</textarea></p>
                            <button class="btn btn-success" type="submit"><fmt:message
                                    key="editcomment.btn.save"/></button>
                            <a class="btn btn-danger"
                               href="controller?command=delcomment&commentId=${comment.commentId}&filmId=${sessionScope.comment.filmId}"
                               role="button">
                                <fmt:message key="editcomment.btn.delete"/></a>
                            <a class="btn btn-warning"
                               href="controller?command=getfilm&filmId=${sessionScope.comment.filmId}"><fmt:message
                                    key="editcomment.btn.cancel"/></a>
                        </div>
                    </div>
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
