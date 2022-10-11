package com.postgre.empl.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.postgre.empl.model.Employee;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode
@Jacksonized
@ToString
public class CompanyEmployeeDTO extends  CompanyDTO implements Serializable {

    @JsonProperty("employees")
    private List<Employee> employeeList;

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.setId(companyDTO.getId());
        this.setCName(companyDTO.getCName());
        this.setCAfm(companyDTO.getCAfm());
    }

    @JsonIgnore
    public CompanyDTO getCompanyDTO(){
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCName(this.getCName());
        return companyDTO;
    }

    public CompanyEmployeeDTO getCompanyEmployeeDTO(){
       CompanyEmployeeDTO companyEmployeeDTO = new CompanyEmployeeDTO();
       companyEmployeeDTO.setEmployeeList(this.getEmployeeList());
       return companyEmployeeDTO;
    }

    public void setCompanyEmployeeDTO(CompanyEmployeeDTO companyEmployeeDTO) {
        this.setId(companyEmployeeDTO.getId());
        this.setCName(companyEmployeeDTO.getCName());
        this.setCAfm(companyEmployeeDTO.getCAfm());
    }
}


