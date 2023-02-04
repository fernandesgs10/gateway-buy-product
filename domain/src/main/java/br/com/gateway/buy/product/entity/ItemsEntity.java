package br.com.gateway.buy.product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "ITEMS")
@Entity
public class ItemsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_ITEMS")
    private Long id;

    @Column(name = "PRODUTO")
    private String produto;

    @Column(name = "PAIS")
    private String pais;

    @Column(name = "VARIEDADE")
    private String variedade;

    @Column(name = "SAFRA")
    private Long safra;

    @Column(name = "PRECO")
    private Double preco;

    @Column(name = "CATEGORIA")
    private String categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRODUCT")
    @JsonBackReference
    @ToString.Exclude
    private ProductEntity productEntity;

}