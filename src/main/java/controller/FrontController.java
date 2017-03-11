package controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class FrontController extends HttpServlet {

    ControllerFactory controllerFactory = new ControllerFactory();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();

        Controller controller = controllerFactory.getControllerByUrl(url);

        if (controller == null) {
            controller = controllerFactory.getDefaultController();
        }

        controller.openPage(request, response);
    }
}
