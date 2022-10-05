package com.postgre.empl.service.dto;


import com.postgre.empl.model.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyDTO {

    private long id;
    private String cName;
    private String cAfm;

    public CompanyDTO(Company company) {
        this.setId(company.getId());
        this.setCName(company.getcName());
        this.setCAfm(company.getcAfm());
    }
}
