package controller.departments;

import controller.Controller;
import model.Department;
import service.DepartmentService;
import service.impl.DepartmentServiceImpl;
import service.impl.sorting.Sort;
import service.impl.sorting.SortByNameAsc;
import service.impl.sorting.SortByNameDsc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AllDepartments implements Controller {

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String sortBy = request.getParameter("sortBy");

            List<Department> departmentList = departmentService.getAll();

            Collections.sort(departmentList, new Sort(sortBy));

            request.setAttribute("departments", departmentList);

            request.getRequestDispatcher("/WEB-INF/pages/departments/all.jsp").forward(request, response);
        }
        catch (Exception e){

            e.printStackTrace();
        }
    }
}

