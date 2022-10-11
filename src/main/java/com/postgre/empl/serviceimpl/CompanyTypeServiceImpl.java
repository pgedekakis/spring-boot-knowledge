package com.postgre.empl.serviceimpl;

import com.postgre.empl.exception.ResourceNotFoundException;
import com.postgre.empl.model.CompanyType;
import com.postgre.empl.repository.CompanyTypeRepository;
import com.postgre.empl.service.CompanyTypeService;
import com.postgre.empl.service.dto.CompanyTypeDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class CompanyTypeServiceImpl implements CompanyTypeService {
    private CompanyTypeRepository companyTypeRepository;

    public CompanyTypeServiceImpl(CompanyTypeRepository companyTypeRepository) {
        super();
        this.companyTypeRepository = companyTypeRepository;
    }
    @Override
    public CompanyType saveCompanyType(CompanyType companyType){
        return companyTypeRepository.save(companyType);
    }
    @Override
    public List<CompanyType> getAllCompanyType(){
        return companyTypeRepository.findAll();
    }
    @Override
    public ResponseEntity<CompanyType> getId(Long id) {
        CompanyType companyType = companyTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompanyType not exist with id :" + id));
        return ResponseEntity.ok(companyType);
    }
    @Override
    public  List<CompanyTypeDTO> getNameCompanyType(){
        List<CompanyType> companyTypeList = companyTypeRepository.findAll();
        List<CompanyTypeDTO> companyTypeDTOS = new ArrayList<>();
        for(CompanyType companyType :companyTypeList){
            CompanyTypeDTO companyTypeDTO = new CompanyTypeDTO(companyType);
            companyTypeDTOS.add(companyTypeDTO);
        }
        return companyTypeDTOS;
    }
    @Override
    public void deleteCompanyType(Long id){
        companyTypeRepository.deleteById(id);

    }
}