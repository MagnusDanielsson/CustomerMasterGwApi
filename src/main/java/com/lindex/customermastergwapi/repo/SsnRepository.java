package com.lindex.customermastergwapi.repo;

import com.lindex.customermastergwapi.entity.Ssn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SsnRepository extends JpaRepository<Ssn, Long> {
    Ssn findBySsnId(Long ssnId);

    @Query("select ssn from Ssn ssn where ssn.country.isoCode = 'SE' and (ssn.ssn like '19______-%' or ssn.ssn like '20______-%')")
    List<Ssn> findAllBySwedishTweleveDigits();

//    Ssn findBySsn(String ssn);
}
