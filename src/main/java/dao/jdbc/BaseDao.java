package dao.jdbc;

import model.BaseModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDao <T extends BaseModel> {

    ExecuteQuery executeQuery = new ExecuteQuery();

}
