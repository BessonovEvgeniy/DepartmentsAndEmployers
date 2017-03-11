package controller.employers;

import controller.Controller;
import model.Employer;
import service.EmployerService;
import service.impl.EmployerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AllEmployers implements Controller {

    EmployerService employerService = new EmployerServiceImpl();

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String depIdStr = request.getParameter("id");

        try {
            if (!depIdStr.isEmpty()) {

                Integer depId = employerService.getIntFromString(depIdStr);

                List<Employer> employerList = employerService.getAllByDepId(depId);

                request.setAttribute("depId",depId);

                request.setAttribute("employers",employerList);

                request.getRequestDispatcher("/WEB-INF/pages/employers/all.jsp").forward(request,response);

            }
            else {
                response.sendRedirect("/departments");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

