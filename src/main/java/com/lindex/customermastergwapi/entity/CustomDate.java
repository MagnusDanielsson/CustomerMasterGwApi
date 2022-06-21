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
@Table(name = "CUSTOM_DATE", schema = "CUSTOMERMASTER")
public class CustomDate extends BaseEntity {

    @Id
    @GeneratedValue(generator = "custom_date_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "custom_date_id_generator", sequenceName = "CUSTOM_DATE_ID_SEQ", allocationSize = 1)
    @Column(name = "CUSTOM_DATE_ID")
    private long customDateId;

    @Column(name = "KEY")
    private String key;

    @Column(name = "VALUE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date value;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_MASTER_ID", referencedColumnName = "CUSTOMER_MASTER_ID", nullable = false)
    private CustomerMaster customerMaster;

}
