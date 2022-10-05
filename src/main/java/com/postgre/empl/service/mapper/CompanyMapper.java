package com.postgre.empl.service.mapper;

import com.postgre.empl.model.Company;
import com.postgre.empl.service.dto.CompanyDTO;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.ComponentScan;


@Mapper(componentModel = "spring")
@ComponentScan
public interface CompanyMapper extends EntityMapper<CompanyDTO, Company> {

    CompanyDTO toDto(Company s);
}