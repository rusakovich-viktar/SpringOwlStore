package by.tms.springstore.service;

import by.tms.springstore.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Product getProductById(Long id);

    void addToUserCart(Long productId, String username);

    void removeAllIdenticalProductsFromUserCart(Long productId, String username);

    void removeOneIdenticalProductFromUserCart(Long productId, String username);

    List<Product> searchProducts(String query);

    Page<Product> getAllProductsByCategoryId(Long categoryId, Pageable pageable);

}