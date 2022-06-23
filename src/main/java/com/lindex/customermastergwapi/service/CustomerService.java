package com.lindex.customermastergwapi.service;

import com.lindex.customermastergwapi.entity.*;
import com.lindex.customermastergwapi.exception.CustomerNotFoundException;
import com.lindex.customermastergwapi.repo.CustomerMasterRepository;
import com.lindex.customermastergwapi.repo.CustomerRepository;
import com.lindex.customermastergwapi.repo.ProspectRepository;
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

    @Autowired
    private ProspectRepository prospectRepository;


    public CustomerResponse getCustomer(Long customerMasterId) {
        CustomerMaster customerMaster = customerMasterRepository.findByCustomerMasterId(customerMasterId);
        if(customerMaster == null)
        {
            log.error("Customer/Prospect {} not found in customermaster", customerMasterId);
            return null;
        }

        CustomerOrProspect cop = findCustomerOrProspect(customerMaster);
        if (cop instanceof Prospect) {
            log.warn("Customermasterid {} is a Prospect", customerMasterId);
            return null;
        }

        Customer customer = customerRepository.findByCustomerMasterId(customerMasterId);
        if (customer == null) {
            log.error("Customer {} not found", customerMasterId);
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


    protected CustomerOrProspect findCustomerOrProspect(CustomerMaster customerMaster) {
        CustomerOrProspect cop = null;

        Customer customer = customerRepository.findByCustomerMasterId(customerMaster.getCustomerMasterId());
        if(customer!=null) {
            cop = customer;
        }
        else {
            Prospect prospect = prospectRepository.findByCustomerMasterId(customerMaster.getCustomerMasterId());
            cop = prospect;
        }
        return cop;
    }

}
