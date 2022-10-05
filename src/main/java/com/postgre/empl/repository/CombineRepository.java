package com.postgre.empl.repository;

import com.postgre.empl.model.Combine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CombineRepository  extends JpaRepository<Combine, Long> {


@Query(value="SELECT combine.empid FROM Combine combine WHERE combine.compid =:companyId")
    List<Long> getEmployeeIds(@Param("companyId") Long companyId);
}
