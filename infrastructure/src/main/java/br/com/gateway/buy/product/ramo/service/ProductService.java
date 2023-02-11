package br.com.gateway.buy.product.ramo.service;

import br.com.gateway.buy.product.common.FinnetConnectException;
import br.com.gateway.buy.product.entity.ProductEntity;
import br.com.gateway.buy.product.enums.ProductRouterEnum;
import br.com.gateway.buy.product.ramo.router.ProductRouter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class ProductService {

    private final ProductRouter productRouter;

    public List<ProductEntity> productsMajorBuyYear(Integer year) {
        try (CamelContext ctx = new DefaultCamelContext()) {
            ctx.addRoutes(productRouter.createRouterProductsMajorBuyYear());
            ctx.start();

            try (ProducerTemplate producerTemplate = ctx.createProducerTemplate()) {
                return producerTemplate.requestBody(ProductRouterEnum.ROUTE_PRODUCTS_MAJOR_BUY_YEAR.getName(), year, List.class);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            if (ex.getCause() != null) {
                Throwable cause = ex.getCause();
                if (cause instanceof HttpClientErrorException.BadRequest) {
                    throw (HttpClientErrorException.BadRequest) cause;
                }
            }
            throw new FinnetConnectException(ex.getMessage());
        }
    }

    public List<ProductEntity> productBuys() {
        try (CamelContext ctx = new DefaultCamelContext()) {
            ctx.addRoutes(productRouter.createRouterProductBuys());
            ctx.start();

            try (ProducerTemplate producerTemplate = ctx.createProducerTemplate()) {
                return producerTemplate.
                        requestBody(ProductRouterEnum.ROUTE_PRODUCTS_BUYS.getName(), null, List.class);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            if (ex.getCause() != null) {
                Throwable cause = ex.getCause();
                if (cause instanceof HttpClientErrorException.BadRequest) {
                    throw (HttpClientErrorException.BadRequest) cause;
                }
            }
            throw new FinnetConnectException(ex.getMessage());
        }
    }
}