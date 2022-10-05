package com.postgre.empl.repository;


import com.postgre.empl.model.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
}
