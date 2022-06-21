package com.lindex.customermastergwapi.repo;

import com.lindex.customermastergwapi.entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, Long> {

    Market findByName(String name);
}
