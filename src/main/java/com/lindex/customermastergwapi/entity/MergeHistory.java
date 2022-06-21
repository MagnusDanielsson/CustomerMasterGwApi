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
@Table(name = "MERGE_HISTORY", schema = "CUSTOMERMASTER")
public class MergeHistory extends BaseEntity {

    @Id
    @GeneratedValue(generator = "merge_history_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "merge_history_id_generator", sequenceName = "MERGE_HISTORY_ID_SEQ", allocationSize = 1)
    @Column(name = "MERGE_HISTORY_ID")
    private long mergeHistoryId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_MASTER_ID", referencedColumnName = "CUSTOMER_MASTER_ID", nullable = false)
    private CustomerMaster customerMaster;

}
