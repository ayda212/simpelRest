package com.simpel.restapi.simpelrestapi.mapper;

import com.simpel.restapi.simpelrestapi.dto.ProductDto;
import com.simpel.restapi.simpelrestapi.entity.Product;
import lombok.AllArgsConstructor;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;

public class ProductMapper implements Converter<Product, ProductDto> {
    @Override
    public ProductDto convert(MappingContext<Product, ProductDto> context) {
        var product  = context.getSource();
        var productDto = context.getDestination();
        ModelMapper modelMapper = new ModelMapper();
        productDto = modelMapper.map(product,ProductDto.class);
        productDto.setCustoms(product.getProductCode()+" "+product.getName());
        return productDto;
    }
}
