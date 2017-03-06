package dao.jdbc;

import com.sun.org.apache.regexp.internal.RE;
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

        String query;

        if (id == null) {
            query = "INSERT INTO departments (name) VALUES ( \'" + name + "\')";
        }
        else {
            query = "INSERT INTO departments (id, name) VALUES (" + id + ", \'" + name + "\') " +
                    "ON CONFLICT (id) DO UPDATE SET name = \'" + name + "\'";
        }

        executeQuery.upsertQuery(query);

        return;
    }

    public boolean isNameUnique(String name) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        String query = "SELECT * FROM departments WHERE name=\'" + name + "\' LIMIT 1";

        ResultSet resultSet = executeQuery.createQuery(query);

        if (resultSet.next()) {
            return true;
        }

        return false;
    }

}
