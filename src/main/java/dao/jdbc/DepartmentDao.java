package dao.jdbc;

import dao.DepartmentRepository;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDao extends BaseDao implements DepartmentRepository {

    public ResultSet findAll() throws SQLException, ClassNotFoundException{

        String query = "SELECT * FROM departments";

        return executeQuery.createQuery(query);
    }
}
