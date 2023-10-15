package com.devcorp.garagesale.domain;

import com.devcorp.garagesale.utility.Size;
import com.devcorp.garagesale.utility.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "seller_products")
public class SellerProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productsId;
    private Type type;
    private Size size;
    private Double price;
    private String photo;

    @ManyToOne
    @JoinColumn(name = "dataId")
    private Seller seller;
}