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
        log.info("Entry save Company Type with argument :{} ",companyType);
        return companyTypeRepository.save(companyType);
    }
    @Override
    public List<CompanyType> getAllCompanyType(){
        log.info("Getting all Company types");
        return companyTypeRepository.findAll();
    }

    @Override
    public ResponseEntity<CompanyType> getId(Long id) {
        CompanyType companyType = companyTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CompanyType not exist with id :" + id));
        log.info("Exit searching type ID");
        return ResponseEntity.ok(companyType);
    }

    @Override
    public  List<CompanyTypeDTO> getNameCompanyType(){
        List<CompanyType> companyTypeList = companyTypeRepository.findAll();
        List<CompanyTypeDTO> companyTypeDTOS = new ArrayList<>();
        for(CompanyType companyType :companyTypeList){
            CompanyTypeDTO companyTypeDTO = new CompanyTypeDTO(companyType);
            companyTypeDTOS.add(companyTypeDTO);
            log.info("Company type added :{} ",companyTypeDTO);
        }
        log.info("Exit loop");
        return companyTypeDTOS;
    }

    @Override
    public void deleteCompanyType(Long id){

        CompanyType companyType=new CompanyType();
        log.info("Company Type ID delete with argument :{} ",id);
        companyTypeRepository.deleteById(id);

    }
}