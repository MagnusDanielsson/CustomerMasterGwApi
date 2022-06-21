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
@Table(name = "CHANNEL_TO_MARKET", schema = "CUSTOMERMASTER")
public class ChannelToMarket extends BaseEntity {

    @Id
    @Column(name = "ID")
    private long channelToMarketId;

    @Column(name = "IS_CHECKED_DEFAULT")
    private boolean isCheckedDefault;

    @Column(name = "IS_VISIBLE")
    private boolean isVisible;

    @Column(name = "LOCAL_NAME")
    private String localName;

    @Column(name = "SORT_ORDER")
    private int sortOrder;

    @Column(name = "VALID_FROM")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validFrom;

    @Column(name = "VALID_TO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date validTo;

    @ManyToOne
    @JoinColumn(name = "CHANNEL_ID", referencedColumnName = "CHANNEL_ID", nullable = false)
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "MARKET_ID", referencedColumnName = "MARKET_ID", nullable = false)
    private Market market;

}
