package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Product;
import by.tms.springstore.repository.ProductRepository;
import by.tms.springstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Setter
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProductsByCategoryId(int categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

}
