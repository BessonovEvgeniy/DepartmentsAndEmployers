package service.impl.sorting;

import model.BaseModel;

import java.util.Comparator;

public class SortByNameAsc<T extends BaseModel> implements Comparator<T> {

    @Override
    public int compare(T object1, T object2) {

        String name1 = object1.getName();
        String name2 = object2.getName();

        int result = name1.compareTo(name2);

        return result;
    }
}
