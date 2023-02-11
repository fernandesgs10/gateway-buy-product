package br.com.gateway.buy.product.controller;

import br.com.gateway.buy.product.api.Product;
import br.com.gateway.buy.product.api.ProdutoApi;
import br.com.gateway.buy.product.entity.ProductEntity;
import br.com.gateway.buy.product.ramo.service.ProductService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${openapi.gatewayBuyProduct.base-path:/v1/gateway-buy-product}")
@AllArgsConstructor
public class ProductController implements ProdutoApi {

    private final ModelMapper modelMapper;
    private final ProductService productService;

    @Override
    @GetMapping(value = "/produto/maior-compra/ano/{year}", produces = {"application/json"})
    public ResponseEntity<List<Product>>  maiorCompraAno(Integer year) {
        var productEntityList = productService.productsMajorBuyYear(year);
        var listProduct = productEntityList.stream()
                .map(item -> modelMapper.map(item, Product.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }

    @Override
    @GetMapping(value = "/produto/compras", produces = {"application/json"})
    public ResponseEntity<List<Product>> listCompras() {
        List<ProductEntity> productEntityList = productService.productBuys();
        List<Product> listProduct = productEntityList.stream()
                .map(item -> modelMapper.map(item, Product.class)).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(listProduct);
    }
}