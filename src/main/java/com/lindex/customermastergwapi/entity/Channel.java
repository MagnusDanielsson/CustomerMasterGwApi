package com.lindex.customermastergwapi.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "CHANNEL", schema = "CUSTOMERMASTER")
public class Channel extends BaseEntity {
    @Id
    @GeneratedValue(generator = "channel_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "channel_id_generator", sequenceName = "CHANNEL_ID_SEQ", allocationSize = 1)
    @Column(name = "CHANNEL_ID")
    private long channelId;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "EXTERNAL_ID")
    private String externalName;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "channel")
    private List<ChannelToMarket> channelToMarkets;

}
