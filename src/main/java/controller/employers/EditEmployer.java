package controller.employers;

import controller.Controller;
import model.Employer;
import service.EmployerService;
import service.impl.EmployerServiceImpl;
import sun.font.LayoutPathImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditEmployer implements Controller {

    EmployerService employerService = new EmployerServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String idStr = request.getParameter("id");

            String depIdStr = request.getParameter("depId");

            Integer id = employerService.getIntFromString(idStr);

            Employer employer = employerService.getById(id);

            if (depIdStr!=null && !depIdStr.isEmpty()){

                Integer depId = employerService.getIntFromString(depIdStr);

                employer.setDepId(depId);
            }

            request.setAttribute("employer", employer);

            request.getRequestDispatcher("/WEB-INF/pages/employers/edit.jsp").forward(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

