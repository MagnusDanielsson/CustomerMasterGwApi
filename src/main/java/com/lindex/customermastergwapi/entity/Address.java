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
@Table(name = "ADDRESS", schema = "CUSTOMERMASTER")
public class Address extends BaseEntity {
    @Id
    @GeneratedValue(generator = "address_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "address_id_generator", sequenceName = "ADDRESS_ID_SEQ", allocationSize = 1)
    @Column(name = "ADDRESS_ID")
    private long addressId;

    @Basic
    @Column(name = "ADDRESS1")
    private String address1;

    @Basic
    @Column(name = "ADDRESS2")
    private String address2;

    @Basic
    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "address")
    private List<Customer> customers;
}
