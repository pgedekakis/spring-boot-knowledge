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
import com.postgre.empl.service.dto.CompanyInformationDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Log4j2
public class CombineServiceImpl implements CombineService {

    private CombineRepository combineRepository;
    private CompanyRepository companyRepository;
    private EmployeeRepository employeeRepository;

    public CombineServiceImpl(CombineRepository combineRepository, CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        super();
        this.combineRepository = combineRepository;
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Combine saveCombine(Combine combine) {
        log.info("Entry save Company Employee with argument :{} ", combine);
        return combineRepository.save(combine);
    }

    @Override
    public List<Combine> getAllCombine() {
        return combineRepository.findAll();
    }

    @Override
    public ResponseEntity<Combine> getId(Long id) {
        Combine combine = combineRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not exist with id :" + id));
        log.info("Exit getId");
        return ResponseEntity.ok(combine);
    }


    public CompanyInformationDTO getInfo(Long companyId) {
        CompanyInformationDTO companyInformationDTO = new CompanyInformationDTO();
        setEmployees(companyId, companyInformationDTO);
        String companyTypeID = combineRepository.getCompanyType(companyId);
        companyInformationDTO.setType(companyTypeID);
        setCompanyDTO(companyId, companyInformationDTO);
        return companyInformationDTO;
    }

    private void setCompanyDTO(Long companyId, CompanyInformationDTO companyInformationDTO) {
        Optional<Company> company = companyRepository.findById(companyId);
        CompanyDTO companyDTO = new CompanyDTO(company.get());
        companyInformationDTO.setCompanyDTO(companyDTO);
    }

    public void setEmployees(Long companyId, CompanyInformationDTO companyInformationDTO) {
        List<Long> employeesIdsList = combineRepository.getEmployeeIds(companyId);
        Set<Long> employeeIds = new HashSet<>(employeesIdsList);
        List<Employee> employees = new ArrayList<>();
        for (Long employeeId : employeeIds) {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if (employee.isPresent()) {
                employees.add(employee.get());
            }
        }
        companyInformationDTO.setEmployeeList(employees);
    }

}
