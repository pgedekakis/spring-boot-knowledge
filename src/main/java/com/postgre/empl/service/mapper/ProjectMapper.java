package com.postgre.empl.service.mapper;


import com.postgre.empl.model.Company;
import com.postgre.empl.service.dto.CompanyDTO;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Data
@Component
public class ProjectMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CompanyDTO toDTO(Company company){
        return  modelMapper.map(company, CompanyDTO.class);
    }

    public Company toEntity(CompanyDTO companyDTO){
        return  modelMapper.map(companyDTO, Company.class);
    }



}
