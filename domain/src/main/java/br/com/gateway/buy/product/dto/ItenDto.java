package br.com.gateway.buy.product.dto;

import lombok.Getter;

@Getter
public class ItenDto {

    private String produto;
    private String variedade;
    private String pais;
    private String categoria;
    private String safra;
    private double preco;
    private String codigo;
}
