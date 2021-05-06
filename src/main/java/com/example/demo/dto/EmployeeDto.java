package com.example.demo.dto;

import com.example.demo.models.Team;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeDto {
    private Integer empno;

    private String ename;

    private Team team;

    private Integer sal;
}
