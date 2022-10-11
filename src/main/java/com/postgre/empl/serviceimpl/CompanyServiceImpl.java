package com.postgre.empl.serviceimpl;

import com.postgre.empl.exception.ResourceNotFoundException;
import com.postgre.empl.model.Combine;
import com.postgre.empl.model.Company;;
import com.postgre.empl.model.CompanyType;
import com.postgre.empl.model.Employee;
import com.postgre.empl.repository.CombineRepository;
import com.postgre.empl.repository.CompanyRepository;
import com.postgre.empl.repository.CompanyTypeRepository;
import com.postgre.empl.repository.EmployeeRepository;
import com.postgre.empl.service.CombineService;
import com.postgre.empl.service.CompanyService;
import com.postgre.empl.service.CompanyTypeService;
import com.postgre.empl.service.dto.CompanyDTO;
import com.postgre.empl.service.dto.CompanyInformationDTO;
import com.postgre.empl.service.mapper.ProjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
@Log4j2
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;
    private ProjectMapper projectMapper;
    private CombineService combineService;
    private CompanyTypeService companyTypeService;
    private CompanyTypeRepository companyTypeRepository;
    private CombineRepository combineRepository;
    private EmployeeRepository employeeRepository;


    public CompanyServiceImpl(CompanyRepository companyRepository,ProjectMapper projectMapper,CompanyTypeService companyTypeService,CombineService combineService,CompanyTypeRepository companyTypeRepository,CombineRepository combineRepository,EmployeeRepository employeeRepository) {
        super();
        this.companyRepository = companyRepository;
        this.projectMapper=projectMapper;
        this.companyTypeService=companyTypeService;
        this.combineService=combineService;
        this.companyTypeRepository=companyTypeRepository;
        this.combineRepository=combineRepository;
        this.employeeRepository=employeeRepository;

    }

    @Override
    public Company saveCompany(Company company){
        log.info("Entry save company with argument :{} ",company);
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
            CompanyDTO companyDTO= projectMapper.toDTO(company);
            companyDTOS.add(companyDTO);
        }
        return companyDTOS;
    }

    @Override
    public void deleteCompany(Long id){
        List<Long> companyTypeIdsList = companyTypeRepository.getCompanyTypeId(id);
        if(!companyTypeIdsList.isEmpty()) {
            companyTypeRepository.deleteAllById(companyTypeIdsList);
        }
        List<Long> combineIdsList = combineRepository.getCombineId(id);
        if(!combineIdsList.isEmpty()) {
            combineRepository.deleteAllById(combineIdsList);
        }
        Optional<Company> company= companyRepository.findById(id);
        if(company.isPresent()) {
            companyRepository.deleteById(id);
        }
    }

    public CompanyInformationDTO createCompanyInfo(CompanyInformationDTO companyInformationDTO){
        Company company= projectMapper.toEntity(companyInformationDTO.getCompanyDTO());
        Company newCompany = saveCompany(company);
        CompanyType companyType= new CompanyType();
        companyType.setcompid(newCompany.getId());
        companyType.setcotype(companyInformationDTO.getType());
        companyTypeService.saveCompanyType(companyType);
        for(Employee employee :companyInformationDTO.getEmployeeList()){
            Combine combine= new Combine();
            combine.setcompid(newCompany.getId());
            combine.setempid(employee.getId());
            combineService.saveCombine(combine);
            log.info("Leaving save Company Employee with argument :{} ", combine);
        }
        employeeRepository.saveAll(companyInformationDTO.getEmployeeList());
        return companyInformationDTO;
    }

    public CompanyInformationDTO updateCompanyInfo(CompanyInformationDTO companyInformationDTO){
         Company company= new Company();
         company.setId(companyInformationDTO.getId());
         company.setcName(companyInformationDTO.getCName());
         company.setcAfm(companyInformationDTO.getCAfm());
         company.setcPhone(companyInformationDTO.getCPhone());
         company.setcYear(companyInformationDTO.getCYear());
        //UPDATES
         companyRepository.save(company);
        updateCompanyTypeInfo(companyInformationDTO);
        updateCombineInfo(companyInformationDTO);
        return companyInformationDTO;
    }
    public CompanyInformationDTO updateCompanyTypeInfo(CompanyInformationDTO companyInformationDTO){
        CompanyType companyType= new CompanyType();
        companyType.setcompid(companyInformationDTO.getId());
        companyType.setcotype(companyInformationDTO.getType());
        companyTypeRepository.save(companyType);
        return companyInformationDTO;
    }
    public CompanyInformationDTO updateCombineInfo(CompanyInformationDTO companyInformationDTO){

        for(Employee employee :companyInformationDTO.getEmployeeList()){
            Combine combine= new Combine();
            combine.setcompid(companyInformationDTO.getId());
            combine.setempid(employee.getId());
            combineService.saveCombine(combine);
            log.info("Leaving save Company Employee with argument :{} ", combine);
        }
        return companyInformationDTO;
    }

}
