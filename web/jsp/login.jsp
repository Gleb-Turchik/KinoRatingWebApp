<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="loginpage.title"/></title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
    <link href="css/signin.css" rel="stylesheet">
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
            <form class="form-signin" action="controller" method="post">
                <input type="hidden" name="command" value="login">
                <h2 class="form-signin-heading"><fmt:message key="loginpage.signin"/></h2>
                <label for="inputEmail" class="sr-only"><fmt:message key="loginpage.email"/></label>
                <input type="email" name="email" id="inputEmail" class="form-control"
                       placeholder="<fmt:message key="loginpage.email"/>" required autofocus>
                <label for="inputPassword" class="sr-only"><fmt:message key="loginpage.password"/></label>
                <input type="password" name="password" id="inputPassword" class="form-control"
                       placeholder="<fmt:message key="loginpage.password"/>" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message
                        key="loginpage.btn.signin"/></button>
                <c:if test="${not empty errmessage}">
                    <div class="alert alert-danger" role="alert">
                            ${errmessage}
                    </div>
                </c:if>
            </form>
        </div><!--/col-xs-12 col-sm-9-->
        <jsp:include page="elements/_sideBar.jsp"/>
    </div><!--/row row-offcanvas-->
    <hr>
    <jsp:include page="elements/_footer.jsp"/>
</div><!--/container-->

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</body>
</html>
