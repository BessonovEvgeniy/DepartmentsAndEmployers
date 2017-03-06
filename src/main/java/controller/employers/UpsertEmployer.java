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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@WebServlet("/employer/save")
public class UpsertEmployer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployerService employerService = new EmployerServiceImpl();

        Employer employer = new Employer();

        String idStr = request.getParameter("id");

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String birthdayStr = request.getParameter("birthday");

        String depIdStr = request.getParameter("depId");

        try {
            if (idStr != null && !idStr.isEmpty()) {

                Integer id = Integer.parseInt(idStr);

                employer = employerService.getById(id);

            }
            if (birthdayStr != null) {

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                Date birthday = simpleDateFormat.parse(birthdayStr);

                employer.setBirthday(birthday);
            }

            employer.setName(name);

            employer.setEmail(email);

//            Map<String,String> errors = employerService.validate(employer);

            Map<String,String> errors;

//            if (!errors.isEmpty()){
//
//                request.setAttribute("errors",errors);
//
//                request.setAttribute("employer",employer);
//
//                request.getRequestDispatcher("/WEB-INF/pages/departments/edit.jsp").forward(request,response);
//
//            }
//            else {

                employerService.upsert(employer);

                response.sendRedirect("/employers?id="+depIdStr);
//            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

