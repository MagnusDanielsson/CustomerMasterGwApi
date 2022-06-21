package com.lindex.customermastergwapi.response;

import com.lindex.customermastergwapi.entity.Customer;
import com.lindex.customermastergwapi.entity.Market;
import lombok.*;
import org.springframework.beans.factory.support.ManagedArray;

import java.util.ArrayList;
import java.util.List;

@ToString
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponse {

    private long customerMasterId;

    private String status;

    private long customerId;

    private String firstName;

    private String lastName;

    private long ssn;

    private String market;

    private List<String> memberShipId = new ArrayList<>();
}
