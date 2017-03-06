<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <title>Edit Department</title>
</head>
<body>
<div class="panel-body">
    <form method="post" id="form" action="/employer/save">
        <div class="col-sm-4">
            <label>Employer Name:</label>
        </div>
        <div class="col-sm-6">
            <c:choose>
                <c:when test="${not empty employer.name}">
                    <input type="text" name="name" value="${employer.name}">
                </c:when>
                <c:otherwise>
                    <input type="text" name="name" value="">
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm-1"></div>
        <div class="col-sm-4">
            <label>Email:</label>
        </div>
        <div class="col-sm-6">
            <c:choose>
                <c:when test="${not empty employer.email}">
                    <input type="text" name="email" value="${employer.email}">
                </c:when>
                <c:otherwise>
                    <input type="text" name="email" value="">
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm-1"></div>
        <div class="col-sm-4">
            <label>Phone:</label>
        </div>
        <div class="col-sm-6">
            <c:choose>
                <c:when test="${not empty employer.phone}">
                    <input type="text" name="phone" value="${employer.phone}">
                </c:when>
                <c:otherwise>
                    <input type="text" name="phone" value="">
                </c:otherwise>
            </c:choose>
        </div>
        <div class="col-sm-1"></div>
        <div class="col-sm-4">
            <label>BirthDay:</label>
        </div>
        <div class="col-sm-6">
            <c:choose>
                <c:when test="${not empty employer.birthday}">
                    <input type="date" name="birthday" value="${employer.birthday}">
                </c:when>
                <c:otherwise>
                    <input type="date" name="birthday">
                </c:otherwise>
            </c:choose>
        </div>
        <input type="hidden" name="depId" value="${employer.depId}">
        <c:choose>
            <c:when test="${not empty employer.id}">
                <input type="hidden" name="id" value="${employer.id}">
            </c:when>
            <c:otherwise>
                <input type="hidden" name="id" value="">
            </c:otherwise>
        </c:choose>
        <div class="col-sm-1"></div>
        <div class="col-sm-4"></div>
        <div class="col-sm-6">
            <c:forEach var="error" items="${errors}">
                <label style="color: red">${error.value}</label>
            </c:forEach>
        </div>
        <div class="col-sm-1"></div>
        <div class="col-sm-4"></div>
        <div class="col-sm-6">
            <c:choose>
                <c:when test="${not empty employer.name}">
                    <input type="submit" value="Update Employer" class="btn btn-success"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Create Employer" class="btn btn-success"/>
                </c:otherwise>
            </c:choose>
        </div>
    </form>
</div>
</body>
</html>
