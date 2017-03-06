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
import java.util.Map;

@WebServlet("/departments/save")
public class UpsertDepartment extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartmentService departmentService = new DepartmentServiceImpl();

        Department department = new Department();

        String idStr = request.getParameter("id");

        String name = request.getParameter("name");

        try {
            if (idStr != null && !idStr.isEmpty()) {

                Integer id = Integer.parseInt(idStr);

                department = departmentService.getById(id);

            }
            department.setName(name);

            Map<String,String> errors = departmentService.validate(department);

            if (!errors.isEmpty()){

                request.setAttribute("errors",errors);

                request.setAttribute("department",department);

                request.getRequestDispatcher("/WEB-INF/pages/departments/edit.jsp").forward(request,response);

            }
            else {

                departmentService.save(department);

                response.sendRedirect("/departments");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

