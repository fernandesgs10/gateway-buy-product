package br.com.gateway.buy.product.repository;

import br.com.gateway.buy.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(
            value = "select * \n" +
                    "from product\n" +
                    "where substring(data, 7,10)= ?1\n" +
                    "order by  valor_total desc\n" +
                    "limit 1\n",
            nativeQuery = true)
    List<ProductEntity> findProductAllByYear(String data);

    @Query("SELECT p FROM ProductEntity p order by p.valorTotal")
    List<ProductEntity> findProductAll();

}
