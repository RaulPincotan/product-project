package refacere.tema6.refaceretema6produtproject.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private CategoryProduct categoryProduct;


    public Product(String name, double price, String description, CategoryProduct categoryProduct) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryProduct = categoryProduct;
    }


}
