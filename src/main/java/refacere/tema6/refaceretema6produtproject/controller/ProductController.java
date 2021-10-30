package refacere.tema6.refaceretema6produtproject.controller;

import org.springframework.web.bind.annotation.*;
import refacere.tema6.refaceretema6produtproject.domain.CategoryProduct;
import refacere.tema6.refaceretema6produtproject.domain.Product;
import refacere.tema6.refaceretema6produtproject.exceptions.ResourceNotFoundException;
import refacere.tema6.refaceretema6produtproject.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    List<Product> getAllProducts(@RequestParam(required = false) CategoryProduct categoryProduct, Double amount) {
        return productService.getProducts(categoryProduct, amount);
    }

    @GetMapping("/{id}")
    Product getProduct(@PathVariable int id) {
        return productService.getProduct(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " cannot be find"));
    }

    @PostMapping
    Product saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    Product deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    Product replaceProduct(@PathVariable Integer id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

}
