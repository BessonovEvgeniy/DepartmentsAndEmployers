package service.impl.sorting;

import model.BaseModel;

import java.util.Comparator;

public class SortByNameDsc<T extends BaseModel> implements Comparator<T> {

    @Override
    public int compare(T object1, T object2) {

        String name1 = object1.getName();
        String name2 = object2.getName();

        int result = name2.compareTo(name1);

        return result;
    }
}
