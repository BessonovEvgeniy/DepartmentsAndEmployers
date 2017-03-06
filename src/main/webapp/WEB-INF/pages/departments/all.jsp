<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
                <a href="/employers/info?id=${department.id}">View employers</a>
            </td>
            <td>
                <a href="/departments/edit?id=${department.id}">Edit</a>
            </td>
            <td>
                <a href="/departments/delete?id=${department.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/departments/edit">Add Department</a>
</div>
</body>
</html>
