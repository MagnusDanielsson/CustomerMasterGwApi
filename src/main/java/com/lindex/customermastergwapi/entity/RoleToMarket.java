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
@Table(name = "ROLE_TO_MARKET", schema = "CUSTOMERMASTER")
public class RoleToMarket extends BaseEntity {

    @Id
    @GeneratedValue(generator = "role_to_market_id_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "role_to_market_id_generator", sequenceName = "ROLE_TO_MARKET_ID_SEQ", allocationSize = 1)
    @Column(name = "ROLE_TO_MARKET_ID")
    private long roleToMarketId;

    @Column(name = "ROLE_NAME")
    private String roleName;

    @ManyToOne
    @JoinColumn(name = "MARKET_ID", referencedColumnName = "MARKET_ID", nullable = false)
    private Market market;

}
