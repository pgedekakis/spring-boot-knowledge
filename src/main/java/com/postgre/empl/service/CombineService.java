package com.postgre.empl.service;


import com.postgre.empl.model.Combine;
import com.postgre.empl.service.dto.CombineDTO;
import com.postgre.empl.service.dto.CompanyEmployeeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CombineService {

    Combine saveCombine(Combine combine);

    List<Combine> getAllCombine();
    ResponseEntity<Combine> getId(Long id);

    CompanyEmployeeDTO getNameCombine(Long companyId);
}
