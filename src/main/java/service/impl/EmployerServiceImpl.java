package service.impl;

import dao.EmployerRepository;
import dao.jdbc.EmployerDao;
import model.BaseModel;
import model.Employer;
import service.EmployerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployerServiceImpl<T extends BaseModel> extends BaseServiceImpl<Employer , EmployerRepository> implements EmployerService {

    protected EmployerRepository dao;
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmployerServiceImpl(){
        dao = new EmployerDao();
    }

    public List<Employer> getAllByDepId(Integer depId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        List<Employer> employerList = new LinkedList<>();

        ResultSet resultSet = dao.findAllByDepId(depId);

        while(resultSet.next()){

            employerList.add(createEmployer(resultSet));

        }

        return employerList;
    }

    public Employer getById(Integer id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        Employer employer = new Employer();

        ResultSet resultSet = dao.findById(id);

        if(resultSet.next()) {

            employer = createEmployer(resultSet);

        }

        return employer;
    }

    public void upsert(Employer employer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        dao.upsert(employer);
    }

    private Employer createEmployer(ResultSet resultSet) throws SQLException{

        Employer employer = new Employer();

        employer.setId(resultSet.getInt("id"));
        employer.setName(resultSet.getString("name"));
        employer.setEmail(resultSet.getString("email"));
        employer.setBirthday(resultSet.getDate("birthday"));
        employer.setPhone(resultSet.getInt("phone"));
        employer.setDepId(resultSet.getInt("department_id"));

        return employer;
    }
}


