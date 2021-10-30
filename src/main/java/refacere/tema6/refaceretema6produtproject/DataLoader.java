package refacere.tema6.refaceretema6produtproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import refacere.tema6.refaceretema6produtproject.domain.CategoryProduct;
import refacere.tema6.refaceretema6produtproject.domain.Product;
import refacere.tema6.refaceretema6produtproject.repositories.ProductRepository;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final ProductRepository productRepository;

    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        productRepository.saveAll(
                List.of(
                        new Product("Detergent", 45, "detergent minune", CategoryProduct.UTILS),
                        new Product("Shaorma", 21, "for a happy deve;oper", CategoryProduct.FOOD),
                        new Product("Pizza Napoletana", 31, "best pizza", CategoryProduct.FOOD),
                        new Product("Meniul zilei", 17, "basic food", CategoryProduct.FOOD),
                        new Product("Casti bluetooth", 225, "for listening salam", CategoryProduct.ELECTRONICS)
                )
        );
    }
}
