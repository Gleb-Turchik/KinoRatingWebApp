<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="resource.pagecontent"/>
<html>
<body>
<hr>
<div id="comments">
    <h3><fmt:message key="comment.title"/></h3>
    <c:choose>
        <c:when test="${sessionScope.user.baned == false}">
            <div class="new-comment-block row">
                <div class="col-sm-6">
                    <form action="controller" method="post">
                        <input type="hidden" name="command" value="addcomment"/>
                        <input type="hidden" name="filmId" value="${film.filmId}">
                        <div class="form-group">
                            <h4><fmt:message key="comment.textarea.title"/>, ${user.name}?</h4>
                        </div>
                        <div class="form-group">
                            <textarea name="text" id="text" cols="25" rows="5"
                                      placeholder="<fmt:message key="comment.textarea.text"/>"
                                      class="form-control"></textarea>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-success"><fmt:message
                                    key="comment.btn.send"/></button>
                        </div>
                    </form>
                </div>
            </div>
        </c:when>
        <c:when test="${sessionScope.user.baned == true}">
            <h4><fmt:message key="comment.ban"/></h4>
        </c:when>
        <c:otherwise>
            <div class="new-comment-block row">
                <div class="col-sm-6">
                    <form>
                        <div class="form-group">
                            <h4><fmt:message key="comment.textarea2.title"/></h4>
                        </div>
                        <div class="form-group">
                            <textarea name="text" id="null" cols="25" rows="5"
                                      placeholder="<fmt:message key="comment.textarea2.text"/>"
                                      class="form-control"></textarea>
                        </div>
                    </form>
                </div>
            </div>
        </c:otherwise>
    </c:choose>

    <c:forEach var="comment" items="${comments}">
        <ul>
            <li>
                <div class="media">
                    <div class="media-left">
                        <img src="../images/avatar/${comment.userId}/ava.jpg" class="img-circle" alt="">
                    </div>
                    <div class="media-body">
                        <a class="media-heading" href="#"><h4>${comment.userName}</h4></a>
                        <p>${comment.text}</p>
                        <div class="date"><fmt:message key="comment.posted"/> ${comment.dateTime}</div>
                        <c:if test="${sessionScope.user.role.roleId == 1}">
                            <a class="btn btn-danger"
                               href="controller?command=delcomment&commentId=${comment.commentId}&filmId=${sessionScope.film.filmId}"
                               role="button">
                                <fmt:message key="comment.btn.delete"/></a>
                            <a class="btn btn-warning"
                               href="controller?command=goeditcomment&commentId=${comment.commentId}" role="button">
                                <fmt:message key="comment.btn.moderate"/></a>
                        </c:if>
                    </div>
                </div>
            </li>
        </ul>
    </c:forEach>

</div>
</body>
</html>
