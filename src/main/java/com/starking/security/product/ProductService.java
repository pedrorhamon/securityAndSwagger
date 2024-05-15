package com.starking.security.product;


import java.util.List;
/**
 * @author pedroRhamon
 */
public interface ProductService {
    List<Product> listAll();
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);
}
