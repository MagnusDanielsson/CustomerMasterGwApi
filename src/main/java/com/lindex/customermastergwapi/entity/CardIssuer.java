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
@Table(name = "CARD_ISSUER", schema = "CUSTOMERMASTER")
public class CardIssuer extends BaseEntity {
    @Id
    @GeneratedValue(generator = "card_issuer_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "card_issuer_id_generator", sequenceName = "CARD_ISSUER_ID_SEQ", allocationSize = 1)
    @Column(name = "CARD_ISSUER_ID")
    private long cardIssuerId;

    @Column(name = "IS_CREDIT")
    private boolean isCredit;

    @Column(name = "ISSUER")
    private String issuer;

    @Column(name = "NUMBER_PREFIX")
    private String numberPrefix;

}
