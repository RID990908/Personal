package com.devcorp.garagesale.service;

import com.devcorp.garagesale.domain.Seller;
import com.devcorp.garagesale.domain.SellerProducts;
import com.devcorp.garagesale.repository.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class SellerService {
    public final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    //Exist
    public boolean existSeller(Integer id) {
        return sellerRepository.findById(id).isPresent();
    }

    //Create
    public Seller createSeller(String name, String contact, String salezone, String address) {
        return sellerRepository.save(Seller.builder().name(name).contact(contact).
                saleZone(salezone).address(address).build());
    }

    //Update
    public Seller updateSeller(Integer id, String name, String contact, String salezone, String address) {
        Seller seller = sellerRepository.findById(id).get();
        seller.setName(name);
        seller.setContact(contact);
        seller.setSaleZone(salezone);
        seller.setAddress(address);
        sellerRepository.save(seller);
        return seller;
    }

    //Delete
    public void deleteSeller(Integer id) {
        if (sellerRepository.findById(id).isPresent())
            sellerRepository.delete(sellerRepository.getById(id));
    }

    //gave me seller info
    public Optional<Seller> getSellerInfo(Integer id) {
        return sellerRepository.findById(id);
    }

    //gave me salezones
    public List<Seller> getAllSaleZones(String salezone) {
        return sellerRepository.getAllBySaleZone(salezone);
    }

}