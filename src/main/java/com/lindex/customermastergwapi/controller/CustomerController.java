package com.lindex.customermastergwapi.controller;

import com.lindex.customermastergwapi.response.CustomerResponse;
import com.lindex.customermastergwapi.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/{customerMasterId}", produces = "application/json")
    public ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long customerMasterId) {
        CustomerResponse customer = customerService.getCustomer(customerMasterId);
        if(customer==null) {
            return ResponseEntity.notFound().build();
        }

        log.info("Customer {} found",customerMasterId);
        return ResponseEntity.ok(customer);
    }

}
