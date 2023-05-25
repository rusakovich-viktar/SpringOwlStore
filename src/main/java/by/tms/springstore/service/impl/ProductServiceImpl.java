//package by.tms.springstore.service.impl;
//
//import by.tms.springstore.model.Product;
//import by.tms.springstore.repository.ProductRepository;
//import by.tms.springstore.service.ProductService;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Setter
//@Service
//@RequiredArgsConstructor
//public class ProductServiceImpl implements ProductService {
//    private final ProductRepository productRepository;
//
//    public List<Product> getProducts() {
//        return productRepository.getProducts();
//    }
//
//    public Product getProductById(int id) {
//        return productRepository.getProductById(id);
//    }
//
//    public List<Product> getProductsByCategoryId(int categoryId) {
//        return productRepository.getProductsByCategoryId(categoryId);
//    }
//
//}
