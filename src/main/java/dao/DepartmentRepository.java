package dao;

import model.Department;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentRepository extends BaseRepository <Department> {

    List<Department> findAll() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    Department findById(Integer id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    void save(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    void delete(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    boolean isNameUnique(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
}
