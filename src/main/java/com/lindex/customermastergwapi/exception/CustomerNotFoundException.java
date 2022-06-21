package com.lindex.customermastergwapi.exception;

public class CustomerNotFoundException extends CustomerMasterGwException {
    public CustomerNotFoundException(long customerMasterId) {
        super(null, "customerMasterId", String.valueOf(customerMasterId), null, "CUSTOMER_NOT_FOUND");
    }
}
