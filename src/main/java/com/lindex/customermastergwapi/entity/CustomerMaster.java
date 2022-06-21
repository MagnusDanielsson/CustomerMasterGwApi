package com.lindex.customermastergwapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "CUSTOMER_MASTER", schema = "CUSTOMERMASTER")
public class CustomerMaster extends BaseEntity {

    @Id
    @GeneratedValue(generator = "customer_master_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_master_id_generator", sequenceName = "CUSTOMER_MASTER_ID_SEQ", allocationSize = 1)
    @Column(name = "CUSTOMER_MASTER_ID")
    private long customerMasterId;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "VALID_EMAIL_ADDRESS")
    private Boolean validEmailAddress;

    @OneToMany(mappedBy = "customerMaster")
    private List<Customer> customers;

    @OneToMany(mappedBy = "customerMaster")
    private List<CustomerMasterNote> customerMasterNotes;

    @OneToMany(mappedBy = "customerMaster")
    private List<CustomDate> customDates;

    @OneToMany(mappedBy = "customerMaster")
    private List<MergeHistory> mergeHistories;

    @OneToMany(mappedBy = "customerMaster")
    private List<Prospect> prospects;
}
