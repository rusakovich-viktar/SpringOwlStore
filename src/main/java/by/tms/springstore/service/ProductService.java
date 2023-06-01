package by.tms.springstore.service;

import by.tms.springstore.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(int id);

    List<Product> getAllProductsByCategoryId(int categoryId);
}