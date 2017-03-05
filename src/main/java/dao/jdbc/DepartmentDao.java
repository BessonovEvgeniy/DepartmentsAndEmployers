package dao.jdbc;

import dao.DepartmentRepository;
import model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao extends BaseDao implements DepartmentRepository {

    public ResultSet findAll() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        String query = "SELECT * FROM departments";

        return executeQuery.createQuery(query);
    }

    public ResultSet findById(Integer id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        String query = "SELECT * FROM departments WHERE id=" + id;

        return executeQuery.createQuery(query);
    }


    public void save(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        Integer id = department.getId();

        String name = department.getName();

        String query = "INSERT INTO departments (id, name) VALUES (" + id + ", \'" + name +"\') " +
                            "ON CONFLICT (id) DO UPDATE SET name = \'" + name + "\' RETURNING *";

        executeQuery.createQuery(query);

        return;
    }
}
