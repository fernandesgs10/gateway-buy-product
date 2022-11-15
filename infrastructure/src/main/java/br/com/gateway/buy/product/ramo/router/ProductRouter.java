package br.com.gateway.buy.product.ramo.router;

import br.com.gateway.buy.product.ramo.exchange.ProductExchange;
import lombok.AllArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductRouter {

    private final ProductExchange productExchange;

    public static final String ROUTE_PRODUCTS_MAJOR_BUY_YEAR = "direct:productsMajorBuyYear";
    public static final String ROUTE_PRODUCTS_BUYS = "direct:productBuys";

    public RouteBuilder createRouterProductsMajorBuyYear() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from(ROUTE_PRODUCTS_MAJOR_BUY_YEAR)
                        .bean(productExchange, "productsMajorBuyYear");
            }
        };
    }

    public RouteBuilder createRouterProductBuys() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from(ROUTE_PRODUCTS_BUYS)
                        .bean(productExchange, "productBuys");
            }
        };
    }
}