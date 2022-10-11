package com.postgre.empl.service.dto;


import com.postgre.empl.model.CompanyType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;

@Data
@NoArgsConstructor
@Log4j2
public class CompanyTypeDTO {

    private long id;
    private long companyId;
    private String companyType;
    private String companyTypeID;

    public CompanyTypeDTO(CompanyType companyType) {
        this.setId(companyType.getId());
        this.setCompanyId(companyType.getcompid());
        this.setCompanyType(companyType.getcotype());
    }

    public CompanyTypeDTO(String companyTypeID) {
        log.info("CompanyTypeID :{} ",companyTypeID);
    }
}