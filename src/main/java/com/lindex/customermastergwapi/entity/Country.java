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
@Table(name = "COUNTRY", schema = "CUSTOMERMASTER")
public class Country extends BaseEntity {

    @Id
    @GeneratedValue(generator = "country_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "country_id_generator", sequenceName = "COUNTRY_ID_SEQ", allocationSize = 1)
    @Column(name = "COUNTRY_ID")
    private long countryId;

    @Column(name = "ISO_CODE")
    private String isoCode;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "country")
    private List<Address> addresses;

    @OneToMany(mappedBy = "country")
    private List<ProspectAddress> prospectAddresses;

    @OneToMany(mappedBy = "country")
    private List<Ssn> ssns;

}
