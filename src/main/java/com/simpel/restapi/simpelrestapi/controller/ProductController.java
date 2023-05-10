package com.simpel.restapi.simpelrestapi.controller;

import com.simpel.restapi.simpelrestapi.dto.ProductDto;
import com.simpel.restapi.simpelrestapi.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Object> createNewProduct(@RequestBody ProductDto productDto){
        productService.doCreateNewProduct(productDto);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Object> updateProduct(@RequestBody ProductDto productDto){
        productService.doUpdateProduct(productDto);
        return ResponseEntity.ok().build();

    }
    @GetMapping("/{productCode}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productCode") String productCode){
        return ResponseEntity.ok().body(productService.doGetProduct(productCode));
    }
    @DeleteMapping("/{productCode}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("productCode") String productCode){
        productService.doDeleteProduct(productCode);
        return ResponseEntity.ok().build();
    }
}
