package dao;

import model.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DepartmentRepository extends BaseRepository <Department> {

    ResultSet findAll() throws SQLException, ClassNotFoundException;
}
