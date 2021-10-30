package refacere.tema6.refaceretema6produtproject.service;

import org.springframework.stereotype.Service;
import refacere.tema6.refaceretema6produtproject.domain.CategoryProduct;
import refacere.tema6.refaceretema6produtproject.domain.Product;
import refacere.tema6.refaceretema6produtproject.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts(CategoryProduct categoryProduct, Double amount) {
        if (categoryProduct == null && amount == null) {
            return productRepository.findAll();
        } else if (amount == null) {
            return productRepository.findByCategoryProduct(categoryProduct);
        } else if (categoryProduct == null) {
            return productRepository.findByPriceGreaterThan(amount);
        } else {
            return productRepository.findByCategoryProductAndPriceGreaterThan(categoryProduct, amount);
        }
    }

    public Optional<Product> getProduct(int id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product deleteProduct(Integer id) {
        Optional<Product> dbProduct = productRepository.findById(id);
        dbProduct.ifPresent(productRepository::delete);
        return dbProduct.orElse(null);
    }

    public Product replaceProduct(Integer id, Product product) {
        product.setId(id);
        return productRepository.save(product);
    }
}
