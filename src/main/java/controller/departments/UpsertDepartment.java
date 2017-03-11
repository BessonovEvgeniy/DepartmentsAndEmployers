package controller.departments;

import controller.Controller;
import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UpsertDepartment implements Controller {

    DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = departmentService.getIntFromString(request.getParameter("id"));

            String name = request.getParameter("name");

            Department department = departmentService.getById(id);

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

