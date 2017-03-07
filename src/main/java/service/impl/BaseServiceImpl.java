package service.impl;

import dao.BaseRepository;
import model.BaseModel;
import service.BaseService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseServiceImpl<T extends BaseModel, P extends BaseRepository<T>>
        implements BaseService {

    protected P dao;

    public void setPersistence(P dao) {
        this.dao = dao;
    }

    public Integer getIntFromString(String idStr) throws ParseException {

        Integer id = null;

        if (idStr != null && !idStr.isEmpty()) {

            id = Integer.parseInt(idStr);
        }

        return id;
    }

    public Date parseStringToDate(String dateStr) throws ParseException {
        if (dateStr != null && !dateStr.isEmpty()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            return simpleDateFormat.parse(dateStr);
        }
        return new Date();
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}

