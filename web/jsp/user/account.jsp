<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="accountpage.title"/></title>

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
                <div class="row details">
                    <div class="col-sm-4">
                        <img class="img-responsive"
                             src="images/avatar/1/avaBig.jpg" alt="">
                    </div>
                    <div class="col-sm-8">
                        <table class="table-striped table">
                            <tr>
                                <td><fmt:message key="account.name"/></td>
                                <td>${sessionScope.user.name}</td>
                            </tr>
                            <tr>
                                <td><fmt:message key="account.surname"/></td>
                                <td>${sessionScope.user.surname}</td>
                            </tr>
                            <tr>
                                <td><fmt:message key="account.email"/></td>
                                <td>${sessionScope.user.email}</td>
                            </tr>
                        </table>
                        <a class="btn btn-default" href="controller?command=goeditprofile"><fmt:message key="account.btn.edit"/></a>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../elements/_sideBar.jsp"/>
    </div>
    <hr>
    <jsp:include page="../elements/_footer.jsp"/>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>
