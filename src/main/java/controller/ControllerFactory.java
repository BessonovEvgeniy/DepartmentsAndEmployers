package controller;

import controller.departments.*;
import controller.employers.*;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

    private Map<String, Controller> controllerMap = new HashMap<>();

    private Controller defaultController = new Home();

    {
        controllerMap.put("/", new Home());

        controllerMap.put("/departments", new AllDepartments());
        controllerMap.put("/departments/add", new AddDepartment());
//        controllerMap.put("/departments/edit", new EditDepartment());
//        controllerMap.put("/departments/save", new UpsertDepartment());
//        controllerMap.put("/departments/delete", new DeleteDepartment());

//        controllerMap.put("/employers", new AllEmployer());
//        controllerMap.put("/employers/add", new AddEmployer());
//        controllerMap.put("/employers/edit", new EditEmployer());
//        controllerMap.put("/employers/save", new UpsertEmployer());
//        controllerMap.put("/employers/delete", new DeleteEmployer());
    }

    public Controller getControllerByUrl(String url) {

        System.out.println(url);
        return controllerMap.get(url);
    }

    public Controller getDefaultController(){
        
        return defaultController;
    }

}
