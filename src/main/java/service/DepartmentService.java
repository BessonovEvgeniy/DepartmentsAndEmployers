package service;

import model.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentService {

    List<Department> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    Department getById(Integer id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
