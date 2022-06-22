package com.lblinh.employee.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lblinh.employee.model.Team;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class EmployeeDTO {
    private int id;
    private int sex;
    private String fullName;
    private int age;
    private String phone;
    private String address;
    private int money;
    private String startDate;
    private String urlImage;
    private int teamId;
    private String teamName;

}