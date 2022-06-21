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
@Table(name = "INTEREST_AREA", schema = "CUSTOMERMASTER")
public class InterestArea extends BaseEntity {

    @Id
    @GeneratedValue(generator = "interest_areas_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "interest_areas_id_generator", sequenceName = "INTEREST_AREA_ID_SEQ", allocationSize = 1)
    @Column(name = "INTEREST_AREA_ID")
    private long interestAreaId;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "NAME")
    private String name;

}
