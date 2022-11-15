package br.com.gateway.buy.product.ramo.exchange;

import br.com.gateway.buy.product.entity.ProductEntity;
import org.apache.camel.Exchange;

import java.util.List;

public interface ProductExchange {

	List<ProductEntity>productsMajorBuyYear(Exchange exchange);

	List<ProductEntity> productBuys(Exchange exchange);

}
