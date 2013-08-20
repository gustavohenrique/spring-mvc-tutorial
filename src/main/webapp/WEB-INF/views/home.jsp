<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Home</title>
<style type="text/css">
body { font-family: Arial; }
ul li img { margin: 2px; }
</style>
</head>

<body>
<h1>Your Facebook Friends | <a href="<c:url value="/signout" />">Sign Out</a></h1>
<ul>
<c:forEach items="${friends}" var="friend">
    <li><img src="http://graph.facebook.com/<c:out value="${friend.id}"/>/picture" align="middle"/> <c:out value="${friend.name}"/></li>
</c:forEach>
</ul>
</body>
</html>
