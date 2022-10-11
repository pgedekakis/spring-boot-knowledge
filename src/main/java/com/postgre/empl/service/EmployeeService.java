package com.postgre.empl.service;

import com.postgre.empl.model.Employee;
import com.postgre.empl.service.dto.EmployeeDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    ResponseEntity<Employee> getId(Long id);
    List<EmployeeDTO> getNameEmployees();
}
