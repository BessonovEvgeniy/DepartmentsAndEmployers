package dao;

import model.BaseModel;

import java.sql.ResultSet;

public interface BaseRepository <T extends BaseModel> {

    ResultSet findAll();
}