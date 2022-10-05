package com.postgre.empl.serviceimpl;

import com.postgre.empl.exception.ResourceNotFoundException;
import com.postgre.empl.model.Company;;
import com.postgre.empl.repository.CompanyRepository;
import com.postgre.empl.service.CompanyService;
import com.postgre.empl.service.dto.CompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CompanyServiceImpl implements CompanyService {


    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        super();
        this.companyRepository = companyRepository;
    }

    @Override
    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }
    @Override
    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    @Override
    public ResponseEntity<Company> getId(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Company not exist with id :" + id));
        return ResponseEntity.ok(company);
    }

    @Override
    public  List<CompanyDTO> getNameCompany(){
        List<Company> companyList = companyRepository.findAll();
        List<CompanyDTO> companyDTOS = new ArrayList<>();
        for(Company company :companyList){
            CompanyDTO companyDTO = new CompanyDTO(company);
            companyDTOS.add(companyDTO);
        }
        return companyDTOS;
    }
}
