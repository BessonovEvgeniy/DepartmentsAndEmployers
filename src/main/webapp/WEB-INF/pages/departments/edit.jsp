<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
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
                    <input type="text" name="name" value="${department.name}">
                    <input type="hidden" name="id" value="${department.id}">
                </div>
            </div>
            <div class="row padding-bot">
                <div class="col-sm-4 col-sm-offset-4">
                    <input type="submit" value="Update Department" class="btn btn-success"/>
                </div>
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>
