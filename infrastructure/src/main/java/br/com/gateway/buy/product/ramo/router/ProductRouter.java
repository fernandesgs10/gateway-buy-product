package br.com.gateway.buy.product.ramo.router;

import br.com.gateway.buy.product.enums.ProductRouterEnum;
import br.com.gateway.buy.product.ramo.exchange.ProductExchange;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductRouter {

    private final ProductExchange productExchange;

    public RouteBuilder createRouterProductsMajorBuyYear() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from(ProductRouterEnum.ROUTE_PRODUCTS_MAJOR_BUY_YEAR.getName())
                        .bean(productExchange, "productsMajorBuyYear");
            }
        };
    }

    public RouteBuilder createRouterProductBuys() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from(ProductRouterEnum.ROUTE_PRODUCTS_BUYS.getName())
                        .bean(productExchange, "productBuys");
            }
        };
    }
}