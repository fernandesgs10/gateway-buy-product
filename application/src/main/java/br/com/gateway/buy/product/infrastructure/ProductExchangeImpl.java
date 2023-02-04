package br.com.gateway.buy.product.infrastructure;

import br.com.gateway.buy.product.dto.ProdutoDto;
import br.com.gateway.buy.product.entity.ProductEntity;
import br.com.gateway.buy.product.mapper.ProductMapper;
import br.com.gateway.buy.product.ramo.exchange.ProductExchange;
import br.com.gateway.buy.product.repository.ItemsRepository;
import br.com.gateway.buy.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class ProductExchangeImpl implements ProductExchange {

    private final ItemsRepository itemsRepository;
    private final ProductRepository productRepository;

    private static List<ProductEntity> listProductEntity() {
        ProdutoDto[] productDto = ProductFileFromURL.downloadProduct();
        List<ProdutoDto> listProdutoDto = Arrays.asList(productDto);
        List<ProductEntity> listProductEntity = ProductMapper.converterProductEntity(listProdutoDto);
        return listProductEntity;
    }

    @Override
    public List<ProductEntity> productsMajorBuyYear(Exchange exchange) {
        listProductEntity().forEach(product -> {
            ProductEntity pr = productRepository.save(product);
            pr.getItens().forEach(it -> {
                it.setProductEntity(pr);
                itemsRepository.save(it);
            });
        });

        Integer data = (Integer) exchange.getIn().getBody();
        return productRepository.findProductAllByYear(String.valueOf(data));
    }

    @Override
    public List<ProductEntity> productBuys(Exchange exchange) {
        listProductEntity().forEach(product -> {
            ProductEntity pr = productRepository.save(product);
            pr.getItens().forEach(it -> {
                it.setProductEntity(pr);
                itemsRepository.save(it);
            });
        });
        return productRepository.findProductAll();
    }
}