package com.simpel.restapi.simpelrestapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Setter
@Getter
public class ProductDto {
    private String name;
    private String productCode;
    private BigInteger price;
    private String customs;
}
