package service.impl;

import dao.EmployerRepository;
import dao.jdbc.EmployerDao;
import model.Employer;
import service.EmployerService;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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

    private static final String USR_NAME_PATTERN = "^[_A-Za-z-\\s]{3,30}$";

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmployerServiceImpl(){
        dao = new EmployerDao();
    }

    public List<Employer> getAllByDepId(Integer depId) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (depId == null){
            return new LinkedList<Employer>();
        }

        return dao.findAllByDepId(depId);
    }

    public Employer getById(Integer id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (id == null){
            return new Employer();
        }

        return dao.findById(id);
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

        pattern = Pattern.compile(USR_NAME_PATTERN);

        matcher = pattern.matcher(employer.getName());

        if (!matcher.matches()){
            errors.put("Wrong Employer name","Enter correct employer name from 3 to 30 chars. Allowed chars is: _,A-Z,a-z, ,-");
        }
        if (employer.getRank() == null || employer.getRank() <=0 || employer.getRank() > 5){
            errors.put("Wrong Rank","Enter Integer employer Rank from 1 to 5");
        }
        if (employer.getEmail() == null || employer.getEmail().isEmpty()) {
            errors.put("Empty email","Enter employer email");
        }
        if (employer.getBirthday() == null || employer.getEmail().isEmpty()){
            errors.put("Empty birthday","Enter employer birthday");
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

    public Employer getEmployerFromServlet(HttpServletRequest request) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, ParseException{

        String idStr = request.getParameter("id");

        String depIdStr = request.getParameter("depId");

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        String birthdayStr = request.getParameter("birthday");

        String rankStr = request.getParameter("rank");

        //Prevent float values
        if (!isInteger(rankStr)){
            rankStr = "0";
        }

        Integer id = getIntFromString(idStr);

        Employer employer = getById(id);

        employer.setDepId(getIntFromString(depIdStr));

        if (!birthdayStr.isEmpty()) {
            employer.setBirthday(new java.sql.Date(parseStringToDate(birthdayStr).getTime()));
        }

        employer.setName(name);

        employer.setEmail(email);

        employer.setRank(getIntFromString(rankStr));

        return employer;
    }
}


