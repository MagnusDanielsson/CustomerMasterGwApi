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
@Table(name = "PROSPECT_ADDRESS", schema = "CUSTOMERMASTER")
public class ProspectAddress extends BaseEntity {

    @Id
    @GeneratedValue(generator = "prospect_address_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "prospect_address_id_generator", sequenceName = "ADDRESS_ID_SEQ", allocationSize = 1)
    @Column(name = "ADDRESS_ID")
    private long addressId;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID")
    private Country country;

    @OneToMany(mappedBy = "prospectAddress")
    private List<Prospect> prospects;

}
