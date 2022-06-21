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
@Table(name = "SIGNUP", schema = "CUSTOMERMASTER")
public class Signup extends BaseEntity {

    @Id
    @GeneratedValue(generator = "signup_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "signup_id_generator", sequenceName = "SIGNUP_ID_SEQ", allocationSize = 1)
    @Column(name = "SIGNUP_ID")
    private long signupId;

    @Column(name = "ORIGIN_NAME")
    private String originName;

    @Column(name = "ORIGIN_VALUE")
    private String originValue;

    @Column(name = "SIGNUP_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date signupDate;

}
