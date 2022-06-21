package com.lindex.customermastergwapi.repo;

import com.lindex.customermastergwapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface CmCustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(long id);

    @Query("select c from CustomerMaster cm, Customer c where c.customerMaster = cm AND cm.customerMasterId = :id")
    Customer findByCustomerMasterId(long id);

    List<Customer> findByFirstName(String firstName);

    @Query("select c from Customer c where c.market.name = :market AND c.engagementType.name = :engagementType")
    Stream<Customer> findByMarketAndEngagementType(String market, String engagementType);

    @Query("select c from Customer c where c.ssn.ssn = :ssnStr")
    Customer findBySsn(String ssnStr);

    @Query("select c from Customer c, Phone ph where c = ph.customer and ph.countryPrefix = :countryPrefix and ph.value = :number")
    List<Customer> findByPhoneNumber(int countryPrefix, String number);

    @Query("select c from Customer c, Signup su where c.customerStatus = 'ACTIVE' and c.signup = su and su.originValue = :value")
    List<Customer> findAllByCustomerStatusEqualsActiveAndSignupOriginValue(String value);

    @Query("select c from Customer c INNER JOIN CustomDate cd ON c.customerMaster.customerMasterId = cd.customerMaster.customerMasterId AND c.acceptMembership = false AND c.customerStatus = 'ACTIVE' AND cd.value is not null AND cd.key = 'ACCEPT_MEMBERSHIP'")
    List<Customer> findAllByActiveCustomersNoMembershipAndMembershipDateNotNull();

}