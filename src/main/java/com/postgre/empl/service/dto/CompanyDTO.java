package com.postgre.empl.service.dto;


import com.postgre.empl.model.Company;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@NoArgsConstructor
public class CompanyDTO {

    private long id;
    private String cName;
    private String cAfm;
    private String cPhone;
    private Date cYear;

    public CompanyDTO(Company company) {
        this.setId(company.getId());
        this.setCPhone(company.getcPhone());
        this.setCName(company.getcName());
        this.setCAfm(company.getcAfm());
        this.setCYear(company.getcYear());
    }
}
