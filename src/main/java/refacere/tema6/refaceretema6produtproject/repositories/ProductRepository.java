package refacere.tema6.refaceretema6produtproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import refacere.tema6.refaceretema6produtproject.domain.CategoryProduct;
import refacere.tema6.refaceretema6produtproject.domain.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryProduct(CategoryProduct categoryProduct);

    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByCategoryProductAndPriceGreaterThan(CategoryProduct categoryProduct, double price);
}
