package dao.jdbc;

import dao.EmployerRepository;
import model.Employer;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Date;

public class EmployerDao extends BaseDao implements EmployerRepository {

    public ResultSet findAllByDepId(Integer depId) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        String query = "SELECT * FROM employers WHERE department_id="+depId;

        return executeQuery.createQuery(query);
    }

    public ResultSet findById(Integer id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        String query = "SELECT * FROM employers WHERE id=" + id;

        return executeQuery.createQuery(query);
    }

    public void delete(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        String query = "DELETE FROM employers WHERE id=?";

        PreparedStatement preparedStatement = executeQuery.getPrepearedStatment(query);

        preparedStatement.setInt(1,employer.getId());

        preparedStatement.executeUpdate();

        return;
    }

    public void upsert(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        Integer id = employer.getId();

        String name = employer.getName();

        Integer depId = employer.getDepId();

        String email = employer.getEmail();

        Date birthday = employer.getBirthday();

        java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());

        Integer rank = employer.getRank();

        String query;

        if (id == null) {
            query = "INSERT INTO employers (department_id, name, email, birthday, rank) " +
                    "VALUES (?, ?, ?, ?, ?)";
        }
        else {
            query = "UPDATE employers SET (department_id, name, email, birthday, rank)" +
                    " = (?, ?, ?, ?, ?) WHERE id=?";
        }

        try (Connection connection = executeQuery.getConnection()){

            PreparedStatement preparedStatement = executeQuery.getPrepearedStatment(query);

            preparedStatement.setInt(1,depId);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,email);
            preparedStatement.setDate(4,sqlDate);
            preparedStatement.setInt(5,rank);

            if (id != null){
                preparedStatement.setInt(6,id);
            }

            preparedStatement.executeUpdate();
            return;
        }
    }

    public boolean isEmailExists(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            StringBuilder query = new StringBuilder("SELECT * FROM employers WHERE email=\'" + employer.getEmail() + "\'");

            if (employer.getId() != null) {
                query.append(" AND id!=" + employer.getId());
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
