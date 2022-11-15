package br.com.gateway.buy.product.mapper;

import br.com.gateway.buy.product.dto.ItenDto;
import br.com.gateway.buy.product.dto.ProdutoDto;
import br.com.gateway.buy.product.entity.ClientEntity;
import br.com.gateway.buy.product.entity.ItemsEntity;
import br.com.gateway.buy.product.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.codehaus.groovy.runtime.DefaultGroovyMethods.collect;

@Builder
@Data
public class ProductMapper implements Serializable {

    public static List<ProductEntity> converterProductEntity(List<ProdutoDto> produtoDto) {
        List<ProductEntity> list = new ArrayList<>();
        produtoDto.forEach(pr -> {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setCodigo(pr.getCodigo());
            productEntity.setData(pr.getData());
            productEntity.setValorTotal(pr.getValorTotal());
            productEntity.setCliente(pr.getCliente());
            productEntity.setItens(converterItemEntity(pr.getItens()));
            list.add(productEntity);
        });

        return list;
    }

    public static List<ItemsEntity> converterItemEntity(List<ItenDto> listItemDto) {
        List<ItemsEntity> list = new ArrayList<>();
        listItemDto.forEach(item -> {
            ItemsEntity itemsEntity = new ItemsEntity();
            itemsEntity.setPais(item.getPais());
            itemsEntity.setCategoria(item.getCategoria());
            itemsEntity.setSafra(Long.parseLong(item.getSafra()));
            itemsEntity.setPreco(item.getPreco());
            itemsEntity.setProduto(item.getProduto());
            itemsEntity.setVariedade(item.getVariedade());
            list.add(itemsEntity);
        });

        return list;
    }







}