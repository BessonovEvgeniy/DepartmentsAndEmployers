package service;

import model.BaseModel;
import model.Employer;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface EmployerService extends BaseService{

    List<Employer> getAllByDepId(Integer depId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    Employer getById(Integer id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void upsert(Employer employer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    void delete(Employer employer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;

    Employer getEmployerFromServlet(HttpServletRequest request) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException;

    Map<String,String> validate(Employer employer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;
}
