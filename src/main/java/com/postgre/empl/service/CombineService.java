package com.postgre.empl.service;


import com.postgre.empl.model.Combine;
import com.postgre.empl.service.dto.CompanyInformationDTO;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface CombineService {

    Combine saveCombine(Combine combine);
    List<Combine> getAllCombine();
    ResponseEntity<Combine> getId(Long id);
    CompanyInformationDTO getInfo(Long companyId);
}
