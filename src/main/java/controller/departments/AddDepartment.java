package controller.departments;

import controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddDepartment implements Controller {

    @Override
    public void openPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("/departments/edit");
    }
}

