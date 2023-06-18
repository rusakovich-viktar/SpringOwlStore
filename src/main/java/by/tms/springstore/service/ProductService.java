package by.tms.springstore.service;

import by.tms.springstore.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(Long id);

    List<Product> getAllProductsByCategoryId(Long categoryId);

    void addToUserCart(Long productId, String username);

    void removeAllIdenticalProductsFromUserCart(Long productId, String username);

    void removeOneIdenticalProductFromUserCart(Long productId, String username);

    List<Product> searchProducts(String query);
}