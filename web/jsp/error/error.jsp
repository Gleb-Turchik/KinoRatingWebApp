<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<head><title>Error Page</title></head>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<body>
    <jsp:include page="../elements/_header.jsp"/>
    <div class="container">
        <div class="row row-offcanvas row-offcanvas-right active">
            <div class="col-xs-12 col-sm-9">
                <p class="text-right visible-xs">
                    <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><fmt:message
                            key="page.btn.toggle"/></button>
                </p>
                Request from ${pageContext.errorData.requestURI} is failed
                <br/>
                Servlet title or type: ${pageContext.errorData.servletName}
                <br/>
                Status code: ${pageContext.errorData.statusCode}
                <br/>
                Exception: ${pageContext.errorData.throwable}
            </div><!--/.col-xs-12.col-sm-9-->
            <%--<jsp:include page="../elements/_sideBar.jsp"/>--%>
        </div><!--/row row-offcanvas-->
        <hr>
        <jsp:include page="../elements/_footer.jsp"/>
    </div><!--/container-->

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
</body>
</html>
