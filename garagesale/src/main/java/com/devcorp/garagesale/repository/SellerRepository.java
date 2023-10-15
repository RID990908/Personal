package com.devcorp.garagesale.repository;

import com.devcorp.garagesale.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller,Integer> {

    List<Seller> getAllBySaleZone(String salezone);
    List<String> getByName(String name);

    Optional<Object> findById(Integer id);
}
