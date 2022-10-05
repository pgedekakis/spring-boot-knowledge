package com.postgre.empl.controller;


import com.postgre.empl.model.Company;
import com.postgre.empl.service.CompanyService;
import com.postgre.empl.service.dto.CompanyDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CompanyController {



    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    //REST API
    @PostMapping("/company")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        return new ResponseEntity<Company>(companyService.saveCompany(company), HttpStatus.CREATED);
    }
    @GetMapping("/company")
    public List<Company> getAllCompany(){
        return companyService.getAllCompany();
    }
    @GetMapping("/company/name")
    public List<CompanyDTO> getNameCompany(){
        return companyService.getNameCompany();
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id) {
        return companyService.getId(id);
    }






}
