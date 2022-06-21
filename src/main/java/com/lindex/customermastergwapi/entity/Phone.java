package com.lindex.customermastergwapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "PHONE", schema = "CUSTOMERMASTER")
public class Phone extends BaseEntity {

    @Id
    @GeneratedValue(generator = "phone_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "phone_id_generator", sequenceName = "PHONE_ID_SEQ", allocationSize = 1)
    @Column(name = "PHONE_ID")
    private long phoneId;

    @Column(name = "COUNTRY_PREFIX")
    private int countryPrefix;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "PROSPECT_ID", referencedColumnName = "PROSPECT_ID")
    private Prospect prospect;

}
