package com.lindex.customermastergwapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "AUDIT_LOG", schema = "CUSTOMERMASTER")
public class AuditLog {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "ACTOR")
    private String actor;

    @Column(name = "CLASS_NAME")
    private String className;

    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "EVENT_NAME")
    private String eventName;

    @Column(name = "LAST_UPDATED")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column(name = "NEW_VALUE")
    private String newValue;

    @Column(name = "OLD_VALUE")
    private String oldValue;

    @Column(name = "PERSISTED_OBJECT_ID")
    private String persistedObjectId;

    @Column(name = "PERSISTED_OBJECT_VERSION")
    private Long persistedObjectVersion;

    @Column(name = "PROPERTY_NAME")
    private String propertyName;

    @Column(name = "URI")
    private String uri;

}
