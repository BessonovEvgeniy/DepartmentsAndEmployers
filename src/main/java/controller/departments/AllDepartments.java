package controller.departments;

import controller.Controller;
import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllDepartments implements Controller {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            request.setAttribute("departments", departmentService.getAll());

            request.getRequestDispatcher("/WEB-INF/pages/departments/all.jsp").forward(request, response);
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
}

