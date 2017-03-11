package controller.employers;

import controller.Controller;
import model.Employer;
import service.EmployerService;
import service.impl.EmployerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteEmployer implements Controller {

    EmployerService employerService = new EmployerServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String idStr = request.getParameter("id");

            Employer employer = employerService.getById(employerService.getIntFromString(idStr));

            employerService.delete(employer);

            response.sendRedirect("/employers?id="+employer.getDepId());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

