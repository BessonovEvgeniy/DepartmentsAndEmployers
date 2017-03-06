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
import java.util.Map;

@WebServlet("/employer/save")
public class UpsertEmployer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployerService employerService = new EmployerServiceImpl();

        Employer employer = new Employer();

        String idStr = request.getParameter("id");

        String depIdStr = request.getParameter("depId");

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String birthdayStr = request.getParameter("birthday");

        String rankStr = request.getParameter("rank");

        try {

            Integer id = employerService.getIntFromString(idStr);

            if (id != null) {

                employer = employerService.getById(id);

            }
            employer.setDepId(employerService.getIntFromString(depIdStr));

            employer.setBirthday(employerService.parseStringToDate(birthdayStr));

            employer.setName(name);

            employer.setEmail(email);

            employer.setRank(employerService.getIntFromString(rankStr));

            Map<String,String> errors = employerService.validate(employer);

            if (!errors.isEmpty()){

                request.setAttribute("errors",errors);

                request.setAttribute("employer",employer);

                request.getRequestDispatcher("/WEB-INF/pages/employers/edit.jsp").forward(request,response);

            }
            else {

                employerService.upsert(employer);

                response.sendRedirect("/employers?id="+depIdStr);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

