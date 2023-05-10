package com.simpel.restapi.simpelrestapi.service;

import com.simpel.restapi.simpelrestapi.dto.ProductDto;
import com.simpel.restapi.simpelrestapi.entity.Product;
import com.simpel.restapi.simpelrestapi.exception.ResponseException;
import com.simpel.restapi.simpelrestapi.mapper.ProductMapper;
import com.simpel.restapi.simpelrestapi.repository.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final ModelMapper modelMapper;

    public void doCreateNewProduct(ProductDto productDto){
        productRepo.findByProductCode(productDto.getProductCode()).ifPresent(value->{throw new ResponseException("duplicate");});
        productRepo.save(Product.builder()
                .productCode(productDto.getProductCode())
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build());
    }
    public void doUpdateProduct(ProductDto productDto){
        var product = productRepo.findByProductCode(productDto.getProductCode()).orElseThrow(()->new ResponseException("not found"));
        product.setName(productDto.getName());
        product.setProductCode(productDto.getProductCode());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }
    public ProductDto doGetProduct(String productCode){
        var product = productRepo.findByProductCode(productCode).orElseThrow(()->new ResponseException("Not Found"));
        return modelMapper.map(product,ProductDto.class);
    }
    @Transactional
    public void doDeleteProduct(String productCode){
        productRepo.deleteByProductCode(productCode);
    }
}
