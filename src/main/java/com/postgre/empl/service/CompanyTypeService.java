package com.postgre.empl.service;


import com.postgre.empl.model.CompanyType;
import com.postgre.empl.service.dto.CompanyTypeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyTypeService {

    CompanyType saveCompanyType(CompanyType companyType);

    List<CompanyType> getAllCompanyType();
    ResponseEntity<CompanyType> getId(Long id);

    List<CompanyTypeDTO> getNameCompanyType();
}
