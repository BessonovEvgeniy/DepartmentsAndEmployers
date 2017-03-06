<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <title>Employers</title>
</head>
<body>
<table id="table-list" class="table table-striped table-bordered">
    <thead>
    <tr>
        <th>Employer name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Employer name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </tfoot>

    <tbody>
    <c:forEach var="employer" items="${employers}">
        <tr>
            <td>
                <span>${employer.name}</span>
            </td>
            <td>
                <a href="/employer/edit?id=${employer.id}">Edit</a>
            </td>
            <td>
                <a href="/employer/delete?id=${employer.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="/employer/edit?depId=${depId}">Add Employer</a>
</div>
</body>
</html>
