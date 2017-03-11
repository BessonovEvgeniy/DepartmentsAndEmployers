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
        controllerMap.put("/department/add", new AddDepartment());
        controllerMap.put("/department/edit", new EditDepartment());
        controllerMap.put("/department/save", new UpsertDepartment());
        controllerMap.put("/department/delete", new DeleteDepartment());

//        controllerMap.put("/employers", new AllEmployers());
//        controllerMap.put("/employers/add", new AddEmployer());
//        controllerMap.put("/employers/edit", new EditEmployer());
//        controllerMap.put("/employers/save", new UpsertEmployer());
//        controllerMap.put("/employers/delete", new DeleteEmployer());
    }

    public Controller getControllerByUrl(String url) {

        return controllerMap.get(url);
    }

    public Controller getDefaultController(){
        
        return defaultController;
    }

}
