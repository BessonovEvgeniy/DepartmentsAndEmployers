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

@WebServlet("/departments/edit")
public class EditDepartment extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartmentService departmentService = new DepartmentServiceImpl();

        try {
            Department department;

            String idStr = request.getParameter("id");

            if (idStr == null){

                department = new Department();

                request.setAttribute("department",department);

                request.getRequestDispatcher("/WEB-INF/pages/departments/edit.jsp").forward(request,response);
            }

            Integer id = Integer.parseInt(request.getParameter("id"));

            department = departmentService.getById(id);

            request.setAttribute("department",department);

            request.getRequestDispatcher("/WEB-INF/pages/departments/edit.jsp").forward(request,response);
        }
        catch (Exception e){

        }
    }
}

