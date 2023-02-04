package br.com.gateway.buy.product.mapper;

import br.com.gateway.buy.product.dto.ProdutoDto;
import br.com.gateway.buy.product.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
public class ProductMapper implements Serializable {

    private static ModelMapper modelMapper;

    public static List<ProductEntity> converterProductEntity(List<ProdutoDto> produtoDto) {
        modelMapper = new ModelMapper();
        var listProduct = produtoDto.stream()
                .map(item -> modelMapper.map(item, ProductEntity.class)).collect(Collectors.toList());

        return listProduct;
    }
}