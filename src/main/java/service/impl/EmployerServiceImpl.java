package service.impl;

import dao.EmployerRepository;
import dao.jdbc.EmployerDao;
import model.Employer;
import service.EmployerService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployerServiceImpl extends BaseServiceImpl implements EmployerService {

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

    public void delete(Employer employer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        dao.delete(employer);
    }

    public Map<String,String> validate(Employer employer) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        Map<String, String> errors = new LinkedHashMap<>();

        if (employer == null){

            errors.put("Employer","Null Value");

            return errors;

        }
        if (employer.getRank() == null || employer.getRank() <=0 || employer.getRank() > 5){

            errors.put("Wrong Rank","Enter employer Rank from 1 to 5");

            return errors;
        }
        if (employer.getEmail() == null || employer.getEmail().isEmpty()) {
            errors.put("Empty email","Enter employer email");
        }

        pattern = Pattern.compile(EMAIL_PATTERN);

        matcher = pattern.matcher(employer.getEmail());

        if (!matcher.matches()){
            errors.put("Email is incorrect","Enter correct email");
        }
        if (dao.isEmailExists(employer)) {
            errors.put("Email is exists","This email is already registered. Try another.");
        }

        return errors;
    }

    private Employer createEmployer(ResultSet resultSet) throws SQLException{

        Employer employer = new Employer();

        employer.setId(resultSet.getInt("id"));
        employer.setName(resultSet.getString("name"));
        employer.setEmail(resultSet.getString("email"));
        employer.setBirthday(resultSet.getDate("birthday"));
        employer.setRank(resultSet.getInt("rank"));
        employer.setDepId(resultSet.getInt("department_id"));

        return employer;
    }
}


