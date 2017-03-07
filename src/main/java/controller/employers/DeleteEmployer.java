package controller.employers;

import model.Employer;
import service.EmployerService;
import service.impl.EmployerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/employer/delete")
public class DeleteEmployer extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployerService employerService = new EmployerServiceImpl();

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

