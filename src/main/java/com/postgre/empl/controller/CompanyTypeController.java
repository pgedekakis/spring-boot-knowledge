package com.postgre.empl.controller;

import com.postgre.empl.model.Company;
import com.postgre.empl.model.CompanyType;
import com.postgre.empl.service.CompanyService;
import com.postgre.empl.service.CompanyTypeService;
import com.postgre.empl.service.dto.CompanyDTO;
import com.postgre.empl.service.dto.CompanyTypeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CompanyTypeController {



    private CompanyTypeService companyTypeService;

    public CompanyTypeController(CompanyTypeService companyTypeService) {
        this.companyTypeService = companyTypeService;
    }


    //REST API
    @PostMapping("/company/type")
    public ResponseEntity<CompanyType> saveCompanyType(@RequestBody CompanyType companyType) {
        return new ResponseEntity<CompanyType>(companyTypeService.saveCompanyType(companyType), HttpStatus.CREATED);
    }
    @GetMapping("/company/type")
    public List<CompanyType> getAllCompanyType(){
        return companyTypeService.getAllCompanyType();
    }
    @GetMapping("/company/type/name")
    public List<CompanyTypeDTO> getNameCompanyType(){
        return companyTypeService.getNameCompanyType();
    }

    @GetMapping("/company/type/{id}")
    public ResponseEntity<CompanyType> getCompanyTypeById(@PathVariable Long id) {
        return companyTypeService.getId(id);
    }

    @DeleteMapping("/company/type/{id}")
    public void deleteCompanyType(@PathVariable Long id) {
         companyTypeService.deleteCompanyType(id);
    }






}
