package com.postgre.empl.service.dto;

import com.postgre.empl.model.Employee;
import lombok.Data;

@Data
public class EmployeeDTO {
    private long id;
    private String firstName;
    private String lastName;

    public EmployeeDTO(Employee employee) {
        this.setId(employee.getId());
        this.setFirstName(employee.getFirstName());
        this.setLastName(employee.getLastName());
    }

}
