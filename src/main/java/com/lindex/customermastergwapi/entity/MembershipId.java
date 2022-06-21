package com.lindex.customermastergwapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "MEMBERSHIP_ID", schema = "CUSTOMERMASTER")
public class MembershipId extends BaseEntity {

    @Id
    @GeneratedValue(generator = "membership_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "membership_id_generator", sequenceName = "MEMBERSHIP_ID_SEQ", allocationSize = 1)
    @Column(name = "MEMBERSHIP_ID")
    private long membershipId;

    @Column(name = "EXPIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date expireDate;

    @Column(name = "VALID_FROM")
    @Temporal(TemporalType.DATE)
    private Date validFrom;

    @Column(name = "VALUE")
    private String value;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "PROSPECT_ID", referencedColumnName = "PROSPECT_ID")
    private Prospect prospect;

}
