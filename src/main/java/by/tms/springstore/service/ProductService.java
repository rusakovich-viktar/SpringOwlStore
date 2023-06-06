package by.tms.springstore.service;

import by.tms.springstore.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(Long id);

    List<Product> getAllProductsByCategoryId(Long categoryId);

    void addToUserCart(Long productId, String username);
}