package service.impl.sorting;

import lombok.Data;
import model.BaseModel;

import java.util.Comparator;

public @Data class Sort<T extends BaseModel> implements Comparator<T>{

    private Comparator sortByRule;

    private SortByFactory sortByFactory = new SortByFactory();

    public Sort(){
        sortByRule = new SortByNameAsc();
    }

    public Sort(Comparator comparator){
        sortByRule = comparator;
    }

    public Sort(String sortBy){

        sortByRule = sortByFactory.getSortByMethod(sortBy);
    }

    @Override
    public int compare(T o1, T o2) {

        return sortByRule.compare(o1,o2);
    }
}
