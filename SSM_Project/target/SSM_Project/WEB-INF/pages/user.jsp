<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>查询UserById。</h3>
    ${ userById }
    <br/>
    <h3>查询UserAll。</h3>
    ${userAll}
<%--    <c:forEach items="${userAll}" var="user">--%>
<%--        ${user}--%>

<%--    </c:forEach>--%>
</body>
</html>
