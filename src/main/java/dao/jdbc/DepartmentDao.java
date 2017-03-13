package dao.jdbc;

import dao.DepartmentRepository;
import model.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class DepartmentDao extends BaseDao implements DepartmentRepository {

    public List<Department> findAll() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        try (Connection connection = executeQuery.getConnection()) {

            try (Statement statement = connection.createStatement()) {

                String query = "SELECT * FROM departments";

                ResultSet resultSet = statement.executeQuery(query);

                return createListDepartment(resultSet);
            }
        }
    }

    public Department findById(Integer id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            try (Statement statement = connection.createStatement()) {

                String query = "SELECT * FROM departments WHERE id=" + id;

                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                    return createDepartment(resultSet);
                }

                return new Department();
            }
        }
    }

    public void save(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            try (Statement statement = connection.createStatement()) {

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
    }

    public void delete(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            try (Statement statement = connection.createStatement()) {

                String query = "DELETE FROM departments WHERE id="+department.getId();

                statement.executeUpdate(query);

                return;
            }
        }
    }

    public boolean isNameUnique(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            try (Statement statement = connection.createStatement()) {

                StringBuilder query = new StringBuilder("SELECT * FROM departments WHERE name=\'" + department.getName()+"\'");

                if (department.getId() != null) {
                    query.append(" AND id!=" + department.getId()+" LIMIT 1");
                }

                ResultSet resultSet = statement.executeQuery(query.toString());

                if (resultSet.next()) {
                    return true;
                }

                return false;
            }
        }
    }

    private Department createDepartment(ResultSet resultSet) throws SQLException{

        Department department = new Department();

        department.setId(resultSet.getInt("id"));
        department.setName(resultSet.getString("name"));

        return department;
    }

    private List<Department> createListDepartment(ResultSet resultSet) throws SQLException{

        List<Department> departmentList = new LinkedList<>();

        while(resultSet.next()) {

            departmentList.add(createDepartment(resultSet));
        }

        return departmentList;
    }
}
