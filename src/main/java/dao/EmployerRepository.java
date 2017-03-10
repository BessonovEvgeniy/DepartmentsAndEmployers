package dao;

import model.Employer;

import java.sql.SQLException;
import java.util.List;

public interface EmployerRepository extends BaseRepository <Employer> {

    List<Employer> findAllByDepId(Integer depId) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    Employer findById(Integer id) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    void upsert(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    void delete(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;

    boolean isEmailExists(Employer employer) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException;
}
