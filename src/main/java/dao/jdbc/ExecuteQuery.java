package dao.jdbc;

import java.sql.*;
import java.util.Properties;

public class ExecuteQuery {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/dep_emp_db";

    //Database credentials
    static final String USER = "postgres";
    static final String PASS = "1";

    Connection connection = null;
    Statement statement = null;

    private Connection getConnection() throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class.forName(JDBC_DRIVER).newInstance();

        Properties connectionsProps = new Properties();

        connectionsProps.put("user",USER);
        connectionsProps.put("password",PASS);

        return DriverManager.getConnection(DB_URL,connectionsProps);
    }

    public ResultSet createQuery(String sql) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        connection = this.getConnection();

        statement = connection.createStatement();

        return statement.executeQuery(sql);

    }

}
