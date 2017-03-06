package dao.jdbc;

import dao.EmployerRepository;
import model.Employer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void upsert(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        Integer id = employer.getId();

        String name = employer.getName();

        Integer depId = employer.getDepId();

        String email = employer.getEmail();

        Date birthday = employer.getBirthday();

        java.sql.Date sqlDate = new java.sql.Date(birthday.getTime());

        Integer phone = employer.getPhone();

        String query;

        if (id == null) {
            query = "INSERT INTO employers (department_id, name, email, birthday, phone) " +
                    "VALUES (?, ?, ?, ?, ?)";
        }
        else {
            query = "UPDATE employers SET (department_id, name, email, birthday, phone)" +
                    " = (?, ?, ?, ?, ?) WHERE id=?";
        }

        PreparedStatement preparedStatement = executeQuery.getPrepearedStatment(query);

        preparedStatement.setInt(1,depId);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,email);
        preparedStatement.setDate(4,sqlDate);
        preparedStatement.setInt(5,phone);

        if (id != null){
            preparedStatement.setInt(6,id);
        }

        preparedStatement.executeUpdate();
        return;
    }
//
//    public boolean isNameUnique(String name) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{
//
//        String query = "SELECT * FROM departments WHERE name=\'" + name + "\' LIMIT 1";
//
//        ResultSet resultSet = executeQuery.createQuery(query);
//
//        if (resultSet.next()) {
//            return true;
//        }
//
//        return false;
//    }

}
