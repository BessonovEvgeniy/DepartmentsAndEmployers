package model;

import lombok.Data;

import java.util.Date;

public @Data class Employer extends BaseModel{

    private String name = new String("");

    private String email;

    private Date birthday;

    private Integer phone;

    private Integer depId;
}
