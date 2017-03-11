package controller.departments;

import controller.Controller;
import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditDepartment implements Controller {

    DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Integer id = departmentService.getIntFromString(request.getParameter("id"));

            Department department = departmentService.getById(id);

            request.setAttribute("department",department);

            request.getRequestDispatcher("/WEB-INF/pages/departments/edit.jsp").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

