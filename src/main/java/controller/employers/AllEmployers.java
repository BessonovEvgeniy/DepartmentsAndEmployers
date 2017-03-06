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
import java.util.List;

@WebServlet("/employers")
public class AllEmployers extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployerService employerService = new EmployerServiceImpl();

        try {
            String depIdStr = request.getParameter("id");

            if (!depIdStr.isEmpty()){

                Integer depId = Integer.parseInt(depIdStr);

                List<Employer> employerList = employerService.getAllByDepId(depId);

                request.setAttribute("employers",employerList);

                request.getRequestDispatcher("/WEB-INF/pages/employers/all.jsp").forward(request,response);

            }

            response.sendRedirect("/departments");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

