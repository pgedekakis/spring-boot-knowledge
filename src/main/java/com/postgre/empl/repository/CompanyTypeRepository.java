package com.postgre.empl.repository;


import com.postgre.empl.model.CompanyType;
import com.postgre.empl.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {

    @Query(value="SELECT companyType.id FROM CompanyType companyType WHERE companyType.compid =:companyId")
    List<Long> getCompanyTypeId(@Param("companyId") Long companyId);

}
