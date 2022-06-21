package com.lindex.customermastergwapi.repo;

import com.lindex.customermastergwapi.entity.CustomerMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerMasterRepository extends JpaRepository<CustomerMaster, Long> {
    CustomerMaster findByEmail(String email);
    CustomerMaster findByCustomerMasterId(long customerMasterId);
}
