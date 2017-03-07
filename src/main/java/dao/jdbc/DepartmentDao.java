package dao.jdbc;

import dao.DepartmentRepository;
import model.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DepartmentDao extends BaseDao implements DepartmentRepository {

    public ResultSet findAll() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        try (Connection connection = executeQuery.getConnection()) {

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM departments";

            return statement.executeQuery(query);
        }
    }

    public ResultSet findById(Integer id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM departments WHERE id=" + id;

            return statement.executeQuery(query);
        }
    }

    public void save(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            Statement statement = connection.createStatement();

            Integer id = department.getId();

            String name = department.getName();

            String query;

            if (id == null) {
                query = "INSERT INTO departments (name) VALUES ( \'" + name + "\')";
            } else {
                query = "UPDATE departments SET name = \'" + name + "\'  WHERE id=" + id;
            }

            statement.executeUpdate(query);

            return;
        }
    }

    public void delete(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            String query = "DELETE FROM departments WHERE id="+department.getId();

            Statement statement = connection.createStatement();

            statement.executeUpdate(query);

            return;
        }
    }

    public boolean isNameUnique(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            StringBuilder query = new StringBuilder("SELECT * FROM departments WHERE name=\'" + department.getName()+"\'");

            if (department.getId() != null) {
                query.append(" AND id!=" + department.getId()+" LIMIT 1");
            }

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query.toString());

            if (resultSet.next()) {
                return true;
            }

            return false;
        }
    }

}
