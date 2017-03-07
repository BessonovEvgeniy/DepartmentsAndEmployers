package dao.jdbc;

import com.sun.org.apache.regexp.internal.RE;
import dao.DepartmentRepository;
import model.Department;
import model.Employer;

import java.sql.PreparedStatement;
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
            query = "UPDATE departments SET name = \'" + name + "\'  WHERE id="+id;
        }

        executeQuery.upsertQuery(query);

        return;
    }

    public void delete(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        String query = "DELETE FROM departments WHERE id=?";

        PreparedStatement preparedStatement = executeQuery.getPrepearedStatment(query);

        preparedStatement.setInt(1,department.getId());

        preparedStatement.executeUpdate();

        return;
    }

    public boolean isNameUnique(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        PreparedStatement preparedStatement;

        if (department.getId() != null) {

            String query = "SELECT * FROM departments WHERE name=? AND id!=? LIMIT 1";
            preparedStatement = executeQuery.getPrepearedStatment(query);

            preparedStatement.setString(1,department.getName());
            preparedStatement.setInt(2,department.getId());
        }
        else {
            String query = "SELECT * FROM departments WHERE name=? LIMIT 1";
            preparedStatement = executeQuery.getPrepearedStatment(query);

            preparedStatement.setString(1,department.getName());
        }


        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return true;
        }

        return false;
    }

}
