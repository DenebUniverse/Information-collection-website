<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除成功</title>
</head>
<body>
<h1>删除成功</h1>

<c:choose>
    <c:when test="${returnPage=='collect'}">
<h3><a href="${returnPage}">返回</a></h3>
    </c:when>
    <c:otherwise>
<h3><a href="${returnPage}?collectId=${collectid}">返回</a></h3>
    </c:otherwise>
</c:choose>

</body>
</html>