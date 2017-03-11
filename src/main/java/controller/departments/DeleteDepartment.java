package controller.departments;

import controller.Controller;
import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteDepartment implements Controller {

    DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            Integer id = departmentService.getIntFromString(request.getParameter("id"));

            Department department = departmentService.getById(id);

            departmentService.delete(department);

            response.sendRedirect("/departments");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

