package br.com.gateway.buy.product.infrastructure;

import br.com.gateway.buy.product.entity.ClientEntity;
import br.com.gateway.buy.product.ramo.exchange.ClientExchange;
import br.com.gateway.buy.product.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
public class ClientExchangeImpl implements ClientExchange {

    private ClientRepository clientRepository;

   @Override
   public ClientEntity clientRecommendation(Exchange exchange) {
        Object[] object = (Object[]) exchange.getIn().getBody();

        String cpf = (String) object[0];
        String nome = (String) object[1];
        String dataNascimento = (String) object[2];
        String numeroCarteirinha = (String) object[3];

        //ClientEntity ramoSoap = clientRepository.pesquisarSegmentoRamo(nome,cpf, dataNascimento, numeroCarteirinha);
        //log.info("Result" + ramoSoap);
        return null;
   }

    @Override
    public ClientEntity clientTrusty(Exchange exchange) {
        return null;
    }
}