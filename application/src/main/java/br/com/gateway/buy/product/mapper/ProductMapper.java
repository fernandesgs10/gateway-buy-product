package br.com.gateway.buy.product.mapper;

import br.com.gateway.buy.product.dto.ProdutoDto;
import br.com.gateway.buy.product.entity.ProductEntity;
import lombok.Builder;
import lombok.Data;
import org.modelmapper.ModelMapper;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class ProductMapper implements Serializable {

    public static List<ProductEntity> converterProductEntity(List<ProdutoDto> produtoDto) {
        ModelMapper modelMapper = new ModelMapper();
        return produtoDto.stream()
                .map(item -> modelMapper.map(item, ProductEntity.class)).collect(Collectors.toList());
    }
}