package br.com.gateway.buy.product.mapper;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Builder
@Data
public class ItemsMapper implements Serializable {

    private Long id;

    private String product;

    private String country;

    private String variety;

    private Long harvest;

    private Double price;

    private String category;

    @JsonBackReference
    @ToString.Exclude
    private ClientMapper clientEntity;

}