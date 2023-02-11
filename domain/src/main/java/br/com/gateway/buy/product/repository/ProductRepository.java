package br.com.gateway.buy.product.repository;

import br.com.gateway.buy.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "SELECT * \n" +
            "FROM product\n" +
            "WHERE SUBSTRING(data, 7,10)= ?1\n" +
            "ORDER BY valor_total DESC\n" +
            "LIMIT 1\n",
            nativeQuery = true)
    List<ProductEntity> findProductAllByYear(String data);

    @Query("SELECT p FROM ProductEntity p order by p.valorTotal")
    List<ProductEntity> findProductAll();

}
