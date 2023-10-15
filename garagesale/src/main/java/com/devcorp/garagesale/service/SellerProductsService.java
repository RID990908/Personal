package com.devcorp.garagesale.service;

import com.devcorp.garagesale.domain.SellerProducts;
import com.devcorp.garagesale.repository.SellerProductsRepository;
import com.devcorp.garagesale.utility.Size;
import com.devcorp.garagesale.utility.Type;
import org.springframework.stereotype.Service;

@Service
public class SellerProductsService {
    public final SellerProductsRepository productsRepository;

    public SellerProductsService(SellerProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //Exist
    public boolean ExistProducts(Integer id) {
        return productsRepository.findBySeller(id);
    }

    //Create
    public SellerProducts createProductList(Type type, Size size, Double price, String photo) {
        return productsRepository.save(SellerProducts.builder().type(type).size(size).price(price).photo(photo).build());
    }
    //Update
    //Delete
    //get products by type
    //get products by size
    //get products by price
}