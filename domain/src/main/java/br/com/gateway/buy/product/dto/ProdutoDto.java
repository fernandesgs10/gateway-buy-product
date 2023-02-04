package br.com.gateway.buy.product.dto;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class ProdutoDto {
    private String codigo;
    private String data;
    private String cliente;
    private ArrayList<ItenDto> itens;
    private double valorTotal;
}
