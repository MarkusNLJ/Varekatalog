package kea.ovelser.demo.repository;

import kea.ovelser.demo.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepInterface extends CrudRepository<Product, Long> {
    Product findProductById(long id);
}
