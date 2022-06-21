package com.lindex.customermastergwapi.service;

import com.lindex.customermastergwapi.entity.Customer;
import com.lindex.customermastergwapi.entity.MembershipId;
import com.lindex.customermastergwapi.exception.CustomerNotFoundException;
import com.lindex.customermastergwapi.repo.CustomerMasterRepository;
import com.lindex.customermastergwapi.repo.CustomerRepository;
import com.lindex.customermastergwapi.response.CustomerResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
@Service
public class CustomerService {

    @Autowired
    private CustomerMasterRepository customerMasterRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerResponse getCustomer(Long customerMasterId) {

        Customer customer = customerRepository.findByCustomerMasterId(customerMasterId);
        if (customer == null) {
            log.error("Customer {} not found !", customerMasterId);
            return null;
        }

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerId(customer.getCustomerId());
        customerResponse.setCustomerMasterId(customer.getCustomerMaster().getCustomerMasterId());
        customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setStatus(customer.getStatus());
        customerResponse.setMarket(customer.getMarket().getName());

        if(customer.getSsn() != null) {
            customerResponse.setSsn(Long.parseLong(customer.getSsn().getSsn()));
        }

        for (MembershipId membershipId : customer.getMembershipIds()) {
            customerResponse.getMemberShipId().add(membershipId.getValue());
        }

        return customerResponse;
    }

}
