package dao.jdbc;

import dao.DepartmentRepository;
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

}
