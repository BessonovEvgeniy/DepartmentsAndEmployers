package model;

import lombok.Data;
import service.impl.sorting.Sort;

public @Data abstract class BaseModel<T extends BaseModel> implements Comparable<T>{

    private Integer id;

    private String name = "";

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()){
            return false;
        }

        BaseModel baseModel = (BaseModel) o;

        return id.equals(baseModel.id);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + (id == null ? 0 : id.hashCode());
        return hash;
    }

    @Override
    public int compareTo(T object) {

        return name.compareTo(object.getName());
    }
}
