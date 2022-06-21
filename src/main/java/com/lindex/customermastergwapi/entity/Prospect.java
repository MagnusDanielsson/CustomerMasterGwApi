package com.lindex.customermastergwapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "PROSPECT", schema = "CUSTOMERMASTER")
public class Prospect extends BaseEntity implements CustomerOrProspect {

    @Id
    @GeneratedValue(generator = "prospect_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "prospect_id_generator", sequenceName = "PROSPECT_ID_SEQ", allocationSize = 1)
    @Column(name = "PROSPECT_ID")
    private long prospectId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "LAST_EXPORT_DATE_UTC")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastExportDateUtc;

    @Column(name = "LAST_IMPORT_DATE_UTC")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastImportDateUtc;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LOCALE")
    private String locale;

    @Column(name = "ACCEPT_MEMBERSHIP")
    private boolean acceptMembership;

    @Column(name = "BIRTH_YEAR")
    private Integer birthYear;

    @Column(name = "PROSPECT_STATUS")
    private String prospectStatus;

    @Column(name = "BIRTH_DATE")
    @Temporal(value = TemporalType.DATE)
    private Date birthDate;

    @Column(name = "E_COMMERCE_CUSTOMER")
    private boolean eCommerceCustomer;

    @ManyToOne
    @JoinColumn(name = "SIGNUP_ID", referencedColumnName = "SIGNUP_ID")
    private Signup signup;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_MASTER_ID", referencedColumnName = "CUSTOMER_MASTER_ID", nullable = false)
    private CustomerMaster customerMaster;

    @ManyToOne
    @JoinColumn(name = "MARKET_ID", referencedColumnName = "MARKET_ID", nullable = false)
    private Market market;

    @ManyToOne
    @JoinColumn(name = "SSN_ID", referencedColumnName = "SSN_ID")
    private Ssn ssn;

    @ManyToOne
    @JoinColumn(name = "ENGAGEMENT_TYPE_ID", referencedColumnName = "ENGAGEMENT_TYPE_ID", nullable = false)
    private EngagementType engagementType;

    @OneToMany
    @JoinTable(name = "PROSPECT_INTEREST_AREA",
            joinColumns = @JoinColumn(name = "PROSPECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "INTEREST_AREA_ID")
    )
    private List<InterestArea> interestAreas;

    @OneToMany
    @JoinTable(name = "PROSPECT_CHANNEL",
            joinColumns = @JoinColumn(name = "PROSPECT_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHANNEL_ID")
    )
    private List<Channel> channels;

    @OneToMany(mappedBy = "prospect", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<ExternalId> externalIds;

    @OneToMany(mappedBy = "prospect", cascade = CascadeType.ALL)
    private Collection<Phone> phones;

    @OneToMany(mappedBy = "prospect", cascade = CascadeType.ALL)
    private Collection<MembershipId> membershipIds;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = true)
    private ProspectAddress prospectAddress;

    @Override
    public String getStatus() {
        return getProspectStatus();
    }

    @Override
    public String toString() {
        return "Prospect{" +
                "prospectId=" + prospectId +
//                ", firstName='" + firstName + '\'' +
//                ", gender='" + gender + '\'' +
//                ", lastExportDateUtc=" + lastExportDateUtc +
//                ", lastImportDateUtc=" + lastImportDateUtc +
//                ", lastName='" + lastName + '\'' +
//                ", locale='" + locale + '\'' +
//                ", acceptMembership=" + acceptMembership +
//                ", birthYear=" + birthYear +
//                ", prospectStatus='" + prospectStatus + '\'' +
//                ", birthDate=" + birthDate +
//                ", eCommerceCustomer=" + eCommerceCustomer +
//                ", signup=" + signup +
//                ", customerMaster=" + customerMaster +
//                ", market=" + market +
//                ", ssn=" + ssn +
//                ", engagementType=" + engagementType +
                '}';
    }
}
