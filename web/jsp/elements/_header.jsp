<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<body>
<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only"><fmt:message key="page.btn.toggle"/></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="controller">Kino Rating</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav">
                <li><a href="controller?command=gohome"><fmt:message key="header.nav.home"/></a></li>
                <li><a href="#about"><fmt:message key="header.nav.top"/> 10</a></li>
                <li><a  href="#contact">придумать что за кнопка</a></li>
            </ul>
            <%--<form class="navbar-form navbar-right" action="controller" method="post">
                <input type="hidden" name="command" value="searchbytitle">
                <input type="text" class="form-control" placeholder="Search..." name="title">
            </form>--%>
            <ul class="nav navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${empty sessionScope.user}">
                        <li><a data-toggle="modal" data-target="#login"><fmt:message key="header.nav.login"/></a></li>
                        <li><a href="controller?command=goregpage"><fmt:message key="header.nav.reg"/></a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a data-toggle="modal" data-target="#account"><fmt:message
                                key="header.nav.greeting"/>, ${sessionScope.user.name}</a></li>
                    </c:otherwise>
                </c:choose>
                <li><a href="controller?command=language&lang=en">ENG</a></li>
                <li><a href="controller?command=language&lang=ru">RUS</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</nav>
<!-- Modal for sign in-->
<div class="modal fade" id="login" tabindex="-1" role="dialog" aria-labelledby="logModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="logModal"><fmt:message key="header.modal.signin.greeting"/></h4>
            </div>
            <div class="modal-body">
                <form class="form-signin" action="controller" method="post">
                    <input type="hidden" name="command" value="login"/>
                    <h2 class="form-signin-heading"><fmt:message key="header.modal.signin.title"/></h2>
                    <div class="form-group">
                        <label for="loginEmail" class="sr-only"><fmt:message key="header.modal.signin.email"/></label>
                        <input type="email" id="loginEmail" name="email" class="form-control"
                               placeholder="<fmt:message key="header.modal.signin.email"/>" required="" autofocus="">
                    </div>
                    <div class="form-group">
                        <label for="loginPassword" class="sr-only"><fmt:message
                                key="header.modal.signin.password"/></label>
                        <input type="password" id="loginPassword" name="password" class="form-control"
                               placeholder="<fmt:message key="header.modal.signin.password"/>" required="">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message
                                key="header.modal.signin.btn.signin"/></button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%--Account --%>
<div class="modal fade" id="account" tabindex="-1" role="dialog" aria-labelledby="regModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="accountID"><fmt:message key="header.modal.account.title"/></h4>
            </div>
            <div class="modal-body">
                <h2 class="form-signin-heading"><fmt:message key="header.modal.account.greeting"/></h2>
                <c:choose>
                    <c:when test="${sessionScope.user.role.roleId == 1}">
                        <a class="btn btn-lg btn-primary btn-block" href="controller?command=goadmin"><fmt:message
                                key="header.modal.account.btn.admin"/></a>
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-lg btn-primary btn-block" href="controller?command=goaccount"><fmt:message
                                key="header.modal.account.btn.account"/></a>
                    </c:otherwise>
                </c:choose>
                <a class="btn btn-lg btn-primary btn-block" href="controller?command=logout"><fmt:message
                        key="header.modal.account.btn.logout"/></a>
            </div>
        </div>
    </div>
</div>
</body>
</html>