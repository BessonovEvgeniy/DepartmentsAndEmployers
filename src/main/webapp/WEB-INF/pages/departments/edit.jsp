<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <title>Edit Department</title>
</head>
<body>
<div class="panel-body">
    <form method="post" id="form" action="/departments/save">
        <fieldset class="form-group">
            <div class="row padding-bot">
                <div class="col-sm-1"></div>
                <div class="col-sm-4">
                    <label>Department Name:</label>
                </div>
                <div class="col-sm-6">
                    <c:choose >
                        <c:when test="${not empty department.name}">
                            <input type="text" name="name" value="${department.name}">
                        </c:when>
                        <c:otherwise>
                            <input type="text" name="name" value="">
                        </c:otherwise>
                    </c:choose>
                    <c:choose >
                        <c:when test="${not empty department.id}">
                            <input type="hidden" name="id" value="${department.id}">
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" name="id" value="">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <c:forEach var="error" items="${errors}">
                <label style="color: red">${error.value}</label>
            </c:forEach>
            <div class="row padding-bot">
                <div class="col-sm-4 col-sm-offset-4">
                    <c:choose >
                        <c:when test="${not empty department.name}">
                            <input type="submit" value="Update Department" class="btn btn-success"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Create Department" class="btn btn-success"/>
                        </c:otherwise>
                    </c:choose>

                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
