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
@Table(name = "CARD", schema = "CUSTOMERMASTER")
public class Card extends BaseEntity {
    @Id
    @GeneratedValue(generator = "card_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "card_id_generator", sequenceName = "CARD_ID_SEQ", allocationSize = 1)
    @Column(name = "CARD_ID")
    private long cardId;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "CARD_NUMBER")
    private String cardNumber;

    @Column(name = "OPEN_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date openDate;

    @Column(name = "TERMINATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date terminationDate;

    @Column(name = "CREDIT")
    private boolean credit;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID", nullable = false)
    private Customer customer;
}
