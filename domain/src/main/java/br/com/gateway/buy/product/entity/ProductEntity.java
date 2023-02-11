package br.com.gateway.buy.product.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Table(name = "PRODUCT")
@Entity
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PRODUCT")
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "DATA")
    private String data;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "CLIENTE")
    private String cliente;

    @OneToMany(mappedBy = "productEntity", fetch = FetchType.LAZY)
    private List<ItemsEntity> itens;

}