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

    <title><fmt:message key="regpage.title"/></title>

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
                <input type="hidden" name="command" value="registration">
                <h2 class="form-signin-heading"><fmt:message key="regpage.signup"/></h2>
                <label for="inputName" class="sr-only"><fmt:message key="regpage.name"/></label>
                <input type="text" name="name" id="inputName" class="form-control"
                       placeholder="<fmt:message key="regpage.name"/>" maxlength="10" required autofocus pattern="[A-Za-zА-Яа-я]{2,10}">
                <label for="inputSurname" class="sr-only"><fmt:message key="regpage.surname"/></label>
                <input type="text" name="surname" id="inputSurname" class="form-control"
                       placeholder="<fmt:message key="regpage.surname"/>" maxlength="10" required autofocus>
                <label for="email" class="sr-only"><fmt:message key="regpage.email"/></label>
                <input type="email" name="email" id="email" class="form-control"
                       placeholder="<fmt:message key="regpage.email"/>" required autofocus><div class="col-sm-5 messages"></div>
                <label for="inputPassword" class="sr-only"><fmt:message key="regpage.password"/></label>
                <input type="password" name="password" id="inputPassword" class="form-control"
                       placeholder="<fmt:message key="regpage.password"/>" maxlength="10" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message
                        key="regpage.btn.signup"/></button>
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
