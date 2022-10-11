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
public class CompanyInformationDTO extends CompanyDTO implements Serializable {


    @JsonProperty("employees")
    private List<Employee> employeeList;

    @JsonProperty("companyType")
    private String type;

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.setId(companyDTO.getId());
        this.setCName(companyDTO.getCName());
        this.setCAfm(companyDTO.getCAfm());
        this.setCYear(companyDTO.getCYear());
        this.setCPhone(companyDTO.getCPhone());
    }

    @JsonIgnore
    public CompanyDTO getCompanyDTO() {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setCName(this.getCName());
        companyDTO.setCAfm(this.getCAfm());
        companyDTO.setCYear(this.getCYear());
        companyDTO.setCPhone(this.getCPhone());
        return companyDTO;
    }



}
