<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ionex
  Date: 3/4/17
  Time: 12:45 AM
  To change this template use File | Settings | File Templates.
--%>
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
                    <input type="text" name="depName">
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
