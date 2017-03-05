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
import java.util.InputMismatchException;
import java.util.Map;

@WebServlet("/departments/edit")
public class GetDepartmentById extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartmentService departmentService = new DepartmentServiceImpl();

        try {

            Integer id = Integer.parseInt(request.getParameter("id"));

            Department department = departmentService.getById(id);

            request.setAttribute("department",department);

            request.getRequestDispatcher("/WEB-INF/pages/departments/edit.jsp").forward(request,response);
        }
        catch (Exception e){

        }
    }
}

