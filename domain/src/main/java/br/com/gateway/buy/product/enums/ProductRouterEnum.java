package br.com.gateway.buy.product.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProductRouterEnum {

    ROUTE_PRODUCTS_BUYS("direct:productBuys"),
    ROUTE_PRODUCTS_MAJOR_BUY_YEAR("direct:productsMajorBuyYear");

    private String name;



}
