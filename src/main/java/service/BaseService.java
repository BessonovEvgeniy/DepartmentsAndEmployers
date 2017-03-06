package service;

import java.text.ParseException;
import java.util.Date;

public interface BaseService<T> {

    Integer getIntFromString(String idStr) throws ParseException;

    Date parseStringToDate(String dateStr) throws ParseException;
}
