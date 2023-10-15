package com.devcorp.garagesale.repository;

import com.devcorp.garagesale.domain.SellerProducts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerProductsRepository extends JpaRepository<SellerProducts, Integer> {
    boolean findBySeller(Integer id);


}

