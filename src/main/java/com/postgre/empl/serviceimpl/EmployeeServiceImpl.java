package com.postgre.empl.serviceimpl;

import com.postgre.empl.exception.ResourceNotFoundException;
import com.postgre.empl.model.Employee;
import com.postgre.empl.repository.EmployeeRepository;
import com.postgre.empl.service.EmployeeService;
import com.postgre.empl.service.dto.EmployeeDTO;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee){
        log.info("Entry save employee with argument :{} ",employee);
        Optional<Employee> savedEmployee = employeeRepository.findByAfm(employee.getafm());
        if (savedEmployee.isPresent()) {
            throw new ResourceNotFoundException("Employee already exist with given afm: " + employee.getafm());
        }
        log.info("Exit save employee");
       return employeeRepository.save(employee);
   }
    @Override
    public List<Employee> getAllEmployees(){
        log.info("Getting all employees");
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<Employee> getId(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        log.info("Exit search for ID");
        return ResponseEntity.ok(employee);
    }

    @Override
   public  List<EmployeeDTO> getNameEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for(Employee employee :employeeList){
          //  log.info("Employee in loop :{} ",employee);
            EmployeeDTO employeeDTO = new EmployeeDTO(employee);
            employeeDTOS.add(employeeDTO);
            log.info("Employee add to list :{} ",employeeDTO);
        }
        log.info("Exit loop");
        return employeeDTOS;
    }




}
