package service.impl.sorting;

import java.util.Comparator;
import java.util.HashMap;


public class SortByFactory {

    private HashMap<String, Comparator> sortBy = new HashMap<>();

    private Comparator defaultComporator = new SortByNameAsc();

    {
        sortBy.put("nameAsc",new SortByNameAsc());
        sortBy.put("nameDsc",new SortByNameDsc());
    }

    public Comparator getSortByMethod(String sortByMethod){

        Comparator comparator = sortBy.get(sortByMethod);

        if (comparator == null) {
            return defaultComporator;
        }
        else {
            return comparator;
        }
    }

    public Comparator getDefaultComporator(){

        return defaultComporator;
    }
}
