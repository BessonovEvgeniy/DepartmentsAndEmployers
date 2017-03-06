package service;

import model.Employer;

import java.sql.SQLException;
import java.util.List;

public interface EmployerService {

    List<Employer> getAllByDepId(Integer depId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
