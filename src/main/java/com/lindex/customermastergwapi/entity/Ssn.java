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
@Table(name = "SSN", schema = "CUSTOMERMASTER")
public class Ssn extends BaseEntity {

    @Id
    @GeneratedValue(generator = "ssn_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ssn_id_generator", sequenceName = "SSN_ID_SEQ", allocationSize = 1)
    @Column(name = "SSN_ID")
    private long ssnId;

    @Column(name = "SSN")
    private String ssn;

    @OneToMany(mappedBy = "ssn")
    private List<Customer> customers;

    @OneToMany(mappedBy = "ssn")
    private List<Prospect> prospects;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", nullable = false)
    private Country country;

}
