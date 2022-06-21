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
@Table(name = "CUSTOMER", schema = "CUSTOMERMASTER")
public class Customer extends BaseEntity implements CustomerOrProspect {

    @Id
    @GeneratedValue(generator = "customer_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "customer_id_generator", sequenceName = "CUSTOMER_ID_SEQ", allocationSize = 1)
    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDate;

    @Column(name = "BIRTH_YEAR")
    private Integer birthYear;

    @Column(name = "CUSTOMER_IDENTIFIED")
    private boolean customerIdentified;

    @Column(name = "CUSTOMER_STATUS")
    private String customerStatus;

    @Column(name = "DECEASED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deceasedDate;

    @Column(name = "E_COMMERCE_CUSTOMER")
    private boolean eCommerceCustomer;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "LAST_EXPORT_DATE_UTC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastExportDateUtc;

    @Column(name = "LAST_IMPORT_DATE_UTC")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastImportDateUtc;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "LOCALE")
    private String locale;

    @Column(name = "ACCEPT_MEMBERSHIP")
    private boolean acceptMembership;

    @OneToMany(mappedBy = "customer")
    private List<Card> cardsByCustomerId;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID", nullable = false)
    private Address address;

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

    @ManyToOne
    @JoinColumn(name = "SIGNUP_ID", referencedColumnName = "SIGNUP_ID")
    private Signup signup;

    @OneToMany
    @JoinTable(name = "CUSTOMER_CHANNEL",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "CHANNEL_ID")
    )
    private List<Channel> channels;

    @OneToMany
    @JoinTable(name = "CUSTOMER_INTEREST_AREA",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "INTEREST_AREA_ID")
    )
    private List<InterestArea> interestAreas;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<ExternalId> externalIds;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Collection<MembershipId> membershipIds;

    @OneToMany(mappedBy = "customer")
    private Collection<MergeHistory> mergeHistories;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Collection<Phone> phones;

    @Override
    public String getStatus() {
        return getCustomerStatus();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
//                ", birthDate=" + birthDate +
//                ", birthYear=" + birthYear +
//                ", customerIdentified=" + customerIdentified +
//                ", customerStatus='" + customerStatus + '\'' +
//                ", deceasedDate=" + deceasedDate +
//                ", eCommerceCustomer=" + eCommerceCustomer +
//                ", firstName='" + firstName + '\'' +
//                ", gender='" + gender + '\'' +
//                ", lastExportDateUtc=" + lastExportDateUtc +
//                ", lastImportDateUtc=" + lastImportDateUtc +
//                ", lastName='" + lastName + '\'' +
//                ", locale='" + locale + '\'' +
//                ", acceptMembership=" + acceptMembership +
//                ", address=" + address +
//                ", customerMaster=" + customerMaster +
//                ", market=" + market +
//                ", ssn=" + ssn +
//                ", engagementType=" + engagementType +
//                ", signup=" + signup +
                '}';
    }
}
