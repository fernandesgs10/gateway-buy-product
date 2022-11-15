package br.com.gateway.buy.product.ramo.exchange;

import br.com.gateway.buy.product.entity.ClientEntity;
import org.apache.camel.Exchange;

public interface ClientExchange {

	ClientEntity clientRecommendation(Exchange exchange);

	ClientEntity clientTrusty(Exchange exchange);

}
