package br.com.gateway.buy.product.mapper;

import br.com.gateway.buy.product.entity.ItemsEntity;
import lombok.Builder;
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

@Builder
@Data
public class ClientMapper implements Serializable {

    private Long id;
    private String name;
    private String cpf;

    private List<ItemsEntity> itemsEntityList;


}