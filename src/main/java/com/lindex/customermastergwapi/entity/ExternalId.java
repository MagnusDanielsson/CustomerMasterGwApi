package com.lindex.customermastergwapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "EXTERNAL_ID", schema = "CUSTOMERMASTER")
public class ExternalId extends BaseEntity {

    @Id
    @GeneratedValue(generator = "externalid_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "externalid_id_generator", sequenceName = "EXTERNAL_ID_SEQ", allocationSize = 1)
    @Column(name = "EXTERNAL_ID")
    private long externalId;

    @Column(name = "SYSTEM_IDENTIFIER")
    private String systemIdentifier;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "PROSPECT_ID", referencedColumnName = "PROSPECT_ID")
    private Prospect prospect;

    @Override
    public String toString() {
        return "ExternalId{" +
                "externalId=" + externalId +
                ", systemIdentifier='" + systemIdentifier + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
