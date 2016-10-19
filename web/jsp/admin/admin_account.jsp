<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title><fmt:message key="adminpage.title"/></title>

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
            <a class="btn btn-default" href="controller?command=searchallfilms"><fmt:message
                    key="admin.btn.filmlist"/></a>
            <a class="btn btn-default" href="controller?command=searchallgenres"><fmt:message
                    key="admin.btn.genrelist"/></a>
            <a class="btn btn-default" href="controller?command=searchallcountries"><fmt:message
                    key="admin.btn.countrylist"/></a>
            <a class="btn btn-default" href="controller?command=searchallusers"><fmt:message
                    key="admin.btn.userlist"/></a>
            <a class="btn btn-default" href="controller?command=searchallcomments"><fmt:message
                    key="admin.btn.commentlist"/></a>
            <hr/>
        </div><!--/.col-xs-12.col-sm-9-->
        <jsp:include page="../elements/_sideBar.jsp"/><!--/.sidebar-offcanvas-->
    </div><!--/row-->
    <hr>
    <jsp:include page="../elements/_footer.jsp"/>
</div>
<script src="../../js/jquery.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/main.js"></script>
</body>
</html>
