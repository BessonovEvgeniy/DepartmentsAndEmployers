package dao.jdbc;

import dao.DepartmentRepository;
import java.sql.ResultSet;

public class DepartmentDao extends BaseDao implements DepartmentRepository {

    @Override
    public ResultSet findAll() {
        return null;
    }
}
