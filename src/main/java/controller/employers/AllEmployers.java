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

@WebServlet("/employers/dep")
public class AllEmployers extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EmployerService employerService = new EmployerServiceImpl();

        try {
            List<Employer> employerList = employerService.getAllByDepId(1);

            request.setAttribute("employers",employerList);

            request.getRequestDispatcher("/WEB-INF/pages/employers/all.jsp").forward(request,response);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

