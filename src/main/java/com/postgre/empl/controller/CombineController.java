package com.postgre.empl.controller;

import com.postgre.empl.model.Combine;
import com.postgre.empl.service.CombineService;
import com.postgre.empl.service.dto.CombineDTO;
import com.postgre.empl.service.dto.CompanyEmployeeDTO;
import com.postgre.empl.service.dto.CompanyInformationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CombineController {


    private CombineService combineService;

    public CombineController(CombineService combineService) {
        this.combineService = combineService;
    }


    //REST API
    @PostMapping("/combine")
    public ResponseEntity<Combine> saveCompany(@RequestBody Combine combine) {
        return new ResponseEntity<Combine>(combineService.saveCombine(combine), HttpStatus.CREATED);
    }
    @GetMapping("/combine")
    public List<Combine> getAllCombine(){
        return combineService.getAllCombine();
    }

    @GetMapping("/company/info/{companyId}")
    public CompanyInformationDTO getInfo(@PathVariable Long companyId){
        CompanyInformationDTO companyInformationDTO = combineService.getInfo(companyId);
        return companyInformationDTO;
    }

    @GetMapping("/combine/{id}")
    public ResponseEntity<Combine> getCombineById(@PathVariable Long id) {
        return combineService.getId(id);
    }



}
