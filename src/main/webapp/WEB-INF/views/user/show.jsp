<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="background: #48762A;">
    <div class="row">

        <div class="twelve columns">
            <h3 style="color: white;">Details</h3>
        </div>

    </div>
</div>

<div class="row">
    <div class="two columns">
        <h5>Users</h5>
        <ul class="side-nav">
            <c:forEach items="${users}" var="user">
                <li><a href="user/show/${user.id}">${user.name}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>


<div class="row">
    <h4>Basic Information</h4>
</div>
<br />

<div class="row">
    <div class="two columns">
        <b>Name:</b>
    </div>
    <div class="ten columns">${user.name}</div>
</div>
<br />
<div class="row">
    <div class="two columns">
        <b>Login:</b>
    </div>
    <div class="ten columns">${user.login}</div>
</div>
<br />
<div class="row">
    <div class="two columns">
        <b>E-mail:</b>
    </div>
    <div class="ten columns">
        <a href="mailto:${user.email}">${user.email}</a>
    </div>
</div>
<br />