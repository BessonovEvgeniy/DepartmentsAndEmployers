<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
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
    <%--<c:forEach var="department" items="${departments}">--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--${department.name}--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<a href="/employers/info?depId=${department.id}">View employers</a>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<a href="/departmens/edit?depId=${department.id}">Edit</a>--%>
            <%--</td>--%>
            <%--<td>--%>
                <%--<a href="/departmens/delete?depId=${department.id}">Delete</a>--%>
            <%--</td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    </tbody>
</table>
</div>
</body>
</html>
