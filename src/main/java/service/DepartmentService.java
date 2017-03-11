package service;

import model.Department;

import java.sql.SQLException;
import java.util.Set;
import java.util.Map;

public interface DepartmentService extends BaseService {

    Set<Department> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    Department getById(Integer id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void save(Department department) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void delete(Department department) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    boolean isNameUnique(Department department) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    Map<String, String> validate(Department department)  throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
