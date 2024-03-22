package co.sena.edu.productsservice.repositories;

import co.sena.edu.productsservice.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
