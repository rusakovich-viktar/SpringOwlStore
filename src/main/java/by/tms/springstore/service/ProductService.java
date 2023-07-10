package by.tms.springstore.service;

import by.tms.springstore.domain.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product getProductById(Long id);

    void addToUserCart(Long productId, String username);

    void removeAllIdenticalProductsFromUserCart(Long productId, String username);

    void removeOneIdenticalProductFromUserCart(Long productId, String username);

    List<Product> searchProducts(String query);

    Page<Product> getAllProductsByCategoryId(Long categoryId, Pageable pageable);

}
