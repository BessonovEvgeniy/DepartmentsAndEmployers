package controller.employers;

import controller.Controller;
import model.Employer;
import service.EmployerService;
import service.impl.EmployerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class UpsertEmployer implements Controller {

    EmployerService employerService = new EmployerServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Employer employer = employerService.getEmployerFromServlet(request);

            Map<String,String> errors = employerService.validate(employer);

            if (!errors.isEmpty()){

                request.setAttribute("errors",errors);

                request.setAttribute("employer",employer);

                request.getRequestDispatcher("/WEB-INF/pages/employers/edit.jsp").forward(request,response);

            }
            else {

                employerService.upsert(employer);

                response.sendRedirect("/employers?id="+employer.getDepId());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

