package com.starking.security.product;


import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author pedroRhamon
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
