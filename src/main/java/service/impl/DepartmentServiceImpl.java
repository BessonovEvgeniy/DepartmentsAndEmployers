package service.impl;

import com.sun.org.apache.regexp.internal.RE;
import dao.DepartmentRepository;
import dao.jdbc.DepartmentDao;
import model.BaseModel;
import model.Department;
import service.BaseService;
import service.DepartmentService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DepartmentServiceImpl<T extends BaseModel> extends BaseServiceImpl<Department , DepartmentRepository> implements DepartmentService{

    DepartmentRepository dao;

    public DepartmentServiceImpl(){
        dao = new DepartmentDao();
    }

    public List<Department> getAll() throws SQLException, ClassNotFoundException {

        List<Department> departmentList = new LinkedList<>();

        ResultSet resultSet = dao.findAll();

        while(resultSet.next()){

            departmentList.add(createDepartment(resultSet));

        }

        return departmentList;
    }

    public Department createDepartment(ResultSet resultSet) throws SQLException{

        Department department = new Department();

        department.setId(resultSet.getInt("id"));
        department.setName(resultSet.getString("name"));

        return department;
    }
}


