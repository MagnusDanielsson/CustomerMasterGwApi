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
@Table(name = "ENGAGEMENT_TYPE", schema = "CUSTOMERMASTER")
public class EngagementType extends BaseEntity {

    @Id
    @GeneratedValue(generator = "engagement_type_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "engagement_type_id_generator", sequenceName = "ENGAGEMENT_TYPE_ID_SEQ", allocationSize = 1)
    @Column(name = "ENGAGEMENT_TYPE_ID")
    private long engagementTypeId;

    @Column(name = "NAME")
    private String name;

}
