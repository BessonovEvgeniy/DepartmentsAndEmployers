package controller.employers;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddEmployer implements Controller {

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String depIdStr = request.getParameter("depId");

        response.sendRedirect("/employer/edit?depId="+depIdStr);
    }
}

