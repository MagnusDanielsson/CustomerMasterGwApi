package com.lindex.customermastergwapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@Entity
@Table(name = "MARKET", schema = "CUSTOMERMASTER")
public class Market extends BaseEntity {

    @Id
    @GeneratedValue(generator = "market_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "market_id_generator", sequenceName = "MARKET_ID_SEQ", allocationSize = 1)
    @Column(name = "MARKET_ID")
    private long marketId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DEFAULT_LOCALE")
    private String defaultLocale;

    @OneToMany(mappedBy = "market")
    private List<ChannelToMarket> channelToMarketsByMarketId;

    @OneToMany(mappedBy = "market")
    private List<Customer> customersByMarketId;

    @OneToMany(mappedBy = "market")
    private List<InterestAreaToMarket> interestAreaToMarketsByMarketId;

    @OneToMany(mappedBy = "market")
    private List<Prospect> prospectsByMarketId;

    @OneToMany(mappedBy = "market")
    private List<RoleToMarket> roleToMarketsByMarketId;

}
