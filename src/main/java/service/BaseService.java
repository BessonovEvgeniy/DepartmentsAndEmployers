package service;

import java.text.ParseException;
import java.util.Date;

public interface BaseService {

    Integer getIntFromString(String idStr);

    Date parseStringToDate(String dateStr) throws ParseException;

    boolean isInteger(String s);
}
