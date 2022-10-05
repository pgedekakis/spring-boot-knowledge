package com.postgre.empl.service.dto;


import com.postgre.empl.model.CompanyType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyTypeDTO {

    private long id;
    private long Cid;
    private String Ctype;

    public CompanyTypeDTO(CompanyType companyType) {
        this.setId(companyType.getId());
        this.setCid(companyType.getcompid());
        this.setCtype(companyType.getcotype());
    }
}