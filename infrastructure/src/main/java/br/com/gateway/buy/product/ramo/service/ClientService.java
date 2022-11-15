package br.com.gateway.buy.product.ramo.service;

import br.com.gateway.buy.product.common.FinnetConnectException;
import br.com.gateway.buy.product.entity.ClientEntity;
import br.com.gateway.buy.product.ramo.router.ClientRouter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Slf4j
@Component
@AllArgsConstructor
public class ClientService {

    private ClientRouter clientRouter;

    public ClientEntity clientsRecommendation() {
        try (CamelContext ctx = new DefaultCamelContext()) {
            ctx.addRoutes(clientRouter.createRouterClientsRecommendation());
            ctx.start();

            try (ProducerTemplate producerTemplate = ctx.createProducerTemplate()) {
                return producerTemplate.
                        requestBody(clientRouter.ROUTE_CLIENT_RECOMMENDATION, null, ClientEntity.class);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            if (ex.getCause() != null) {
                Throwable cause = ex.getCause();
                if (cause instanceof HttpClientErrorException.BadRequest) {
                    HttpClientErrorException.BadRequest bd = (HttpClientErrorException.BadRequest) cause;
                    throw bd;
                }
            }
            throw new FinnetConnectException(ex.getMessage());
        }
    }

    public ClientEntity clientTrusty() {
        try (CamelContext ctx = new DefaultCamelContext()) {
            ctx.addRoutes(clientRouter.createRouterClientTrusty());
            ctx.start();

            try (ProducerTemplate producerTemplate = ctx.createProducerTemplate()) {
                return producerTemplate.
                        requestBody(clientRouter.ROUTE_CLIENT_TRUSTY, null, ClientEntity.class);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            if (ex.getCause() != null) {
                Throwable cause = ex.getCause();
                if (cause instanceof HttpClientErrorException.BadRequest) {
                    HttpClientErrorException.BadRequest bd = (HttpClientErrorException.BadRequest) cause;
                    throw bd;
                }
            }
            throw new FinnetConnectException(ex.getMessage());
        }
    }
}