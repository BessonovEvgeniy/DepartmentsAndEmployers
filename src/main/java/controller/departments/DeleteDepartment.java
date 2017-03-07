package controller.departments;

import model.Department;
import model.Employer;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/department/delete")
public class DeleteDepartment extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DepartmentService departmentService = new DepartmentServiceImpl();

        try {
            String idStr = request.getParameter("id");

            Department department = departmentService.getById(departmentService.getIntFromString(idStr));

            departmentService.delete(department);

            response.sendRedirect("/departments");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

