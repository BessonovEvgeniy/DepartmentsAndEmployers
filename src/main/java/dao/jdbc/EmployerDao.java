package dao.jdbc;

import dao.EmployerRepository;
import model.Employer;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EmployerDao extends BaseDao implements EmployerRepository {

    public List<Employer> findAllByDepId(Integer depId) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        try (Connection connection = executeQuery.getConnection()) {

            try (Statement statement = connection.createStatement()) {

                String query = "SELECT * FROM employers WHERE department_id=" + depId;

                return createListEmployer(statement.executeQuery(query));
            }
        }
    }

    public Employer findById(Integer id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()){

            try (Statement statement = connection.createStatement()){

                Employer employer = new Employer();

                String query = "SELECT * FROM employers WHERE id=" + id;

                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()){
                    employer = createEmployer(resultSet);
                }

                return employer;
            }
        }

    }

    public void delete(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            try (Statement statement = connection.createStatement()){

                String query = "DELETE FROM employers WHERE id="+employer.getId();

                statement.executeUpdate(query);

                return;
            }
        }
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

            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

                preparedStatement.setInt(1, depId);
                preparedStatement.setString(2, name);
                preparedStatement.setString(3, email);
                preparedStatement.setDate(4, sqlDate);
                preparedStatement.setInt(5, rank);

                if (id != null) {
                    preparedStatement.setInt(6, id);
                }

                preparedStatement.executeUpdate();
                return;
            }
        }
    }

    public boolean isEmailExists(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException{

        try (Connection connection = executeQuery.getConnection()) {

            try (Statement statement = connection.createStatement()){

                StringBuilder query = new StringBuilder("SELECT * FROM employers WHERE email=\'" + employer.getEmail() + "\'");

                if (employer.getId() != null) {
                    query.append(" AND id!=" + employer.getId());
                }

                ResultSet resultSet = statement.executeQuery(query.toString());

                if (resultSet.next()) {
                    return true;
                }

                return false;
            }
        }
    }

    private Employer createEmployer(ResultSet resultSet) throws SQLException{

        Employer employer = new Employer();

        employer.setId(resultSet.getInt("id"));
        employer.setName(resultSet.getString("name"));
        employer.setEmail(resultSet.getString("email"));
        employer.setBirthday(resultSet.getDate("birthday"));
        employer.setRank(resultSet.getInt("rank"));
        employer.setDepId(resultSet.getInt("department_id"));

        return employer;
    }

    private List<Employer> createListEmployer(ResultSet resultSet) throws SQLException{

        List<Employer> employerList = new LinkedList<>();

        while (resultSet.next()){

            employerList.add(createEmployer(resultSet));
        }

        return employerList;
    }
}
