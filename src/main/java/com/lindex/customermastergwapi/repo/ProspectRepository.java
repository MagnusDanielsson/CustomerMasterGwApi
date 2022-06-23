package com.lindex.customermastergwapi.repo;

import com.lindex.customermastergwapi.entity.Prospect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProspectRepository extends JpaRepository<Prospect, Long> {

    @Query("select p from CustomerMaster cm, Prospect p where p.customerMaster = cm AND cm.customerMasterId = :id")
    Prospect findByCustomerMasterId(long id);

}
