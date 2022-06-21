package com.lindex.customermastergwapi.entity;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface CustomerOrProspect {

    Date getDateCreated();

    String getFirstName();

    String getLastName();

    String getGender();

    /** Abstraction of getCustomerStatus() and getProspectStatus()
     * @see Customer#getCustomerStatus()
     * @see Prospect#getProspectStatus()
     * @return the status (ACTIVE/REMOVED) of the customer or prospect
     */
    String getStatus();

    Date getLastExportDateUtc();

    Date getLastImportDateUtc();

    String getLocale();

    boolean isAcceptMembership();

    Integer getBirthYear();

    Date getBirthDate();

    boolean isECommerceCustomer();

    Signup getSignup();
    void setSignup(Signup signup);

    CustomerMaster getCustomerMaster();

    Market getMarket();

    Ssn getSsn();

    EngagementType getEngagementType();

    List<InterestArea> getInterestAreas();

    List<Channel> getChannels();
    void setChannels(List<Channel> channels);

    void setUpdatedBy(String updatedBy);

    Collection<ExternalId> getExternalIds();

}
