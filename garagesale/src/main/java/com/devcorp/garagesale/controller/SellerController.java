package com.devcorp.garagesale.controller;

import com.devcorp.garagesale.domain.Seller;
import com.devcorp.garagesale.domain.dto.SellerDTO;
import com.devcorp.garagesale.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/")
public class SellerController {
    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PutMapping(value = "/register")
    public ResponseEntity registerSeller(@RequestBody SellerDTO seller) {
     // if (!sellerService.existSeller(seller.getDataId()))
            return ResponseEntity.ok(sellerService.createSeller(seller.getName(), seller.getContact(),
                    seller.getSaleZone(), seller.getAddress()));
//        return ResponseEntity.badRequest().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateSeller(Integer id, @RequestBody SellerDTO seller) {
        if (sellerService.existSeller(id))
            return ResponseEntity.ok(sellerService.updateSeller(id, seller.getName(), seller.getContact(), seller.getSaleZone()
                    ,seller.getAddress()));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity deleteSeller(Integer id) {
        sellerService.deleteSeller(id);
        if (!sellerService.existSeller(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/salezones")
    public ResponseEntity<List<Seller>> getSaleZones(String salezones) {
        return ResponseEntity.ok(sellerService.getAllSaleZones(salezones));
    }

    @GetMapping(value = "/sellerInfo")
    public ResponseEntity<Optional<Seller>> getSellerInfo(Integer id) {
        return ResponseEntity.ok(sellerService.getSellerInfo(id));
    }


}
