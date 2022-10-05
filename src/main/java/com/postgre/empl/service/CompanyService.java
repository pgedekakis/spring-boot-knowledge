package com.postgre.empl.service;

import com.postgre.empl.model.Company;
import com.postgre.empl.service.dto.CompanyDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    List<Company> getAllCompany();
    ResponseEntity<Company> getId(Long id);

    List<CompanyDTO> getNameCompany();
}
