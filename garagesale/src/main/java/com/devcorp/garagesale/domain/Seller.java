package com.devcorp.garagesale.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "seller_data")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dataId;
    private String name;
    private String contact;
    private String address;
    @Column(name = "sale_zone")
    private String saleZone;

    @OneToMany(mappedBy = "seller")
    private Collection<SellerProducts> sellerProducts;

}
