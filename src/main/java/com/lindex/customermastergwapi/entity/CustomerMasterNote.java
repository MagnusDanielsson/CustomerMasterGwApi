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
@Table(name = "CUSTOMER_MASTER_NOTE", schema = "CUSTOMERMASTER")
public class CustomerMasterNote extends BaseEntity {

    @Id
    @GeneratedValue(generator = "customer_master_note_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_master_note_id_generator", sequenceName = "CUSTOMER_MASTER_NOTE_ID_SEQ", allocationSize = 1)
    @Column(name = "CUSTOMER_MASTER_NOTE_ID")
    private long customerMasterNoteId;

    @Column(name = "NOTE")
    private String note;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_MASTER_ID", referencedColumnName = "CUSTOMER_MASTER_ID", nullable = false)
    private CustomerMaster customerMaster;

}
