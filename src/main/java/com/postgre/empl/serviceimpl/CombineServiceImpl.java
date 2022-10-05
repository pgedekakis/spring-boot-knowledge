package com.postgre.empl.serviceimpl;


import com.postgre.empl.exception.ResourceNotFoundException;
import com.postgre.empl.model.Combine;
import com.postgre.empl.model.Company;
import com.postgre.empl.model.Employee;
import com.postgre.empl.repository.CombineRepository;
import com.postgre.empl.repository.CompanyRepository;
import com.postgre.empl.repository.EmployeeRepository;
import com.postgre.empl.service.CombineService;
import com.postgre.empl.service.dto.CompanyDTO;
import com.postgre.empl.service.dto.CompanyEmployeeDTO;
import com.postgre.empl.service.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CombineServiceImpl implements CombineService{

    private CombineRepository combineRepository;
    private CompanyRepository companyRepository;
    private EmployeeRepository employeeRepository;


    public CombineServiceImpl(CombineRepository combineRepository,CompanyRepository companyRepository,EmployeeRepository employeeRepository) {
        super();
        this.combineRepository = combineRepository;
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Combine saveCombine(Combine combine){
        return combineRepository.save(combine);
    }
    @Override
    public List<Combine> getAllCombine(){
        return combineRepository.findAll();
    }

    @Override
    public ResponseEntity<Combine> getId(Long id) {
        Combine combine = combineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not exist with id :" + id));
        return ResponseEntity.ok(combine);
    }

    @Override
    public  CompanyEmployeeDTO getNameCombine(Long companyId){
        //List<CompanyEmployeeDTO> companyEmployeeDTO = new ArrayList<>();
        CompanyEmployeeDTO companyEmployeeDTO = new CompanyEmployeeDTO();
        List<Long> employeesIdsList = combineRepository.getEmployeeIds(companyId);
        Set<Long> employeeIds = new HashSet<>(employeesIdsList);
        List<Employee> employees = new ArrayList<>();
        for(Long employeeId :employeeIds){
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if(employee.isPresent()){
                employees.add(employee.get());
            }
        }
        companyEmployeeDTO.setEmployeeList(employees);
        Optional<Company> company= companyRepository.findById(companyId);
        CompanyDTO companyDTO = new CompanyDTO(company.get());
        companyEmployeeDTO.setCompanyDTO(companyDTO);
        return companyEmployeeDTO;
    }
}
