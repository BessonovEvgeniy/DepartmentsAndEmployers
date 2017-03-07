package model;

import lombok.Data;

import java.util.Date;

public @Data class Employer extends BaseModel{

    private String email;

    private Date birthday;

    private Integer rank;

    private Integer depId;
}
