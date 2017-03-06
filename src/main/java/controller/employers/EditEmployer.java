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

@WebServlet("/employer/edit")
public class EditEmployer extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployerService employerService = new EmployerServiceImpl();

        try {
            Employer employer;

            String idStr = request.getParameter("id");

            if (idStr == null || idStr.isEmpty()){

                employer = new Employer();

                request.setAttribute("employer",employer);

                request.getRequestDispatcher("/WEB-INF/pages/employers/edit.jsp").forward(request,response);
            }

            Integer id = Integer.parseInt(request.getParameter("id"));

            employer = employerService.getById(id);

            request.setAttribute("employer",employer);

            request.getRequestDispatcher("/WEB-INF/pages/employers/edit.jsp").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

