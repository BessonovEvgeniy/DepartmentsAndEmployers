<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <title>Departments</title>
</head>
<body>
<table id="table-list" class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Department name</th>
        <th>View employers</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Department name</th>
        <th>View employers</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </tfoot>

    <tbody>
    <c:forEach var="department" items="${departments}">
        <tr>
            <td>
                <span>${department.name}</span>
            </td>
            <td>
                <a href="/employers?id=${department.id}">View employers</a>
            </td>
            <td>
                <a href="/department/edit?id=${department.id}">Edit</a>
            </td>
            <td>
                <a href="/department/delete?id=${department.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a class="btn btn-info" role="button" href="/department/edit">Add Department</a>
</div>
</body>
</html>
