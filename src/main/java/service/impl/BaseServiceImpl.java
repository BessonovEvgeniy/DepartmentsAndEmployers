package service.impl;

import dao.BaseRepository;
import model.BaseModel;
import service.BaseService;

public abstract class BaseServiceImpl<T extends BaseModel, P extends BaseRepository<T>>
        implements BaseService<T> {

    protected  P dao;

    public void setPersistence(P dao){
        this.dao = dao;
    }
}
