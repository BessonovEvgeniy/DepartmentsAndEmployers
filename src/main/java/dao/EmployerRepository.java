package dao;

import model.Employer;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EmployerRepository extends BaseRepository <Employer> {

    ResultSet findAllByDepId(Integer depId) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

//    ResultSet findById(Integer id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
//
//    void save(Department department) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
//
//    boolean isNameUnique(String name) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
}
