package service.impl;

import dao.DepartmentRepository;
import dao.jdbc.DepartmentDao;
import model.Department;
import service.DepartmentService;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DepartmentServiceImpl extends BaseServiceImpl implements DepartmentService{

    protected DepartmentRepository dao;
    private Pattern pattern;
    private Matcher matcher;

    private static final String DEP_NAME_PATTERN = "^[_A-Za-z0-9-\\s]{3,30}$";

    public DepartmentServiceImpl(){
        dao = new DepartmentDao();
    }

    public List<Department> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        return dao.findAll();
    }

    public Department getById(Integer id) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        if (id == null) {
            return new Department();
        }
        return dao.findById(id);
    }

    public void save(Department department) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        dao.save(department);
    }

    public void delete(Department department) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        dao.delete(department);
    }

    public boolean isNameUnique(Department department) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        return dao.isNameUnique(department);
    }

    public Map<String, String> validate(Department department) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{

        Map<String, String> errors = new LinkedHashMap<>();

        if (department == null){

            errors.put("Department","Null Value");

            return errors;

        }

        pattern = Pattern.compile(DEP_NAME_PATTERN);

        matcher = pattern.matcher(department.getName());

        if (!matcher.matches()) {

            errors.put("name", "Department name must have from 3 to 30 chars. Allowed chars is: _,A-Z,a-z,0-9, ,-, ");
        }
        else if (dao.isNameUnique(department)){

            errors.put("name", "Department name must be unique. The " + department.getName() + " is already exists.");
        }

        return errors;
    }
}


