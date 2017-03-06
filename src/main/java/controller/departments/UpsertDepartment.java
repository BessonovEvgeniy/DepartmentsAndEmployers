package controller.departments;

import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/departments/save")
public class UpsertDepartment extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartmentService departmentService = new DepartmentServiceImpl();

        String idStr = request.getParameter("id");

        String name = request.getParameter("name");

        Department department;

        try {
            if (idStr == null || idStr.isEmpty()) {

                department = new Department();

                department.setName(name);

                departmentService.save(department);

                response.sendRedirect("/departments");

            } else {
                Integer id = Integer.parseInt(idStr);

                department = departmentService.getById(id);

                department.setName(name);

                departmentService.save(department);

                response.sendRedirect("/departments");
            }
        }
        catch (Exception e){

        }
    }
}

