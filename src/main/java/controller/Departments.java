package controller;

import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/departments")
public class Departments extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("POST");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartmentService departmentService = new DepartmentServiceImpl();

        try {
            List<Department> departmentList = departmentService.getAll();
        }
        catch (Exception e){
        }

        request.getRequestDispatcher("/WEB-INF/pages/departments/departments.jsp").forward(request,response);
    }
}
