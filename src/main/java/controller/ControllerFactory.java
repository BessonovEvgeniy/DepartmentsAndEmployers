package controller;

import controller.departments.AddDepartment;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public @Data class ControllerFactory {

    private Map<String, Controller> controllerMap = new HashMap<>();

    private Controller defaultController = new Home();

    {
        controllerMap.put("/", new Home());
        controllerMap.put("/departments/add", new AddDepartment());
    }

    public Controller getControllerByUrl(String url) {
        return controllerMap.get(url);
    }

}
