package mk.ukim.finki.emt.inventorymanagement.domain.repository;

import mk.ukim.finki.emt.inventorymanagement.domain.models.Product;
import mk.ukim.finki.emt.inventorymanagement.domain.models.ProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, ProductId> {

}
