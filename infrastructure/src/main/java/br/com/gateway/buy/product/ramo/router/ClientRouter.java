package br.com.gateway.buy.product.ramo.router;

import br.com.gateway.buy.product.ramo.exchange.ClientExchange;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClientRouter {

    private final ClientExchange clientExchange;

    public static final String ROUTE_CLIENT_RECOMMENDATION = "direct:clientRecommendation";
    public static final String ROUTE_CLIENT_TRUSTY = "direct:clientTrusty";

    public RouteBuilder createRouterClientsRecommendation() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from(ROUTE_CLIENT_RECOMMENDATION)
                        .bean(clientExchange, "clientsRecommendation");
            }
        };
    }

    public RouteBuilder createRouterClientTrusty() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from(ROUTE_CLIENT_TRUSTY)
                        .bean(clientExchange, "clientTrusty");
            }
        };
    }
}