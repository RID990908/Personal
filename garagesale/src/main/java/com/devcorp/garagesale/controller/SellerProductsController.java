package com.devcorp.garagesale.controller;

import com.devcorp.garagesale.service.SellerProductsService;
import com.devcorp.garagesale.utility.Size;
import com.devcorp.garagesale.utility.Type;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seller")
public class SellerProductsController {
    public final SellerProductsService productsService;

    public SellerProductsController(SellerProductsService productsService) {
        this.productsService = productsService;
    }

    @PutMapping(value = "/create")
    public ResponseEntity fillProducts(Integer id, Type type, Size size, Double price, String photo) {
        if (!productsService.ExistProducts(id))
            return ResponseEntity.ok(productsService.createProductList(type, size, price, photo));
        return ResponseEntity.badRequest().build();

    }
}
