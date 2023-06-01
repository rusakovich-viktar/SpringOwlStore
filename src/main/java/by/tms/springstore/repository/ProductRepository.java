package by.tms.springstore.repository;

import by.tms.springstore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();
    //        List<Product> getProducts ();

    Product findById(int id);
    //    Product getProductById(int id);

    List<Product> findAllByCategoryId(int categoryId);
    //    List<Product> getProductsByCategoryId(int categoryId);
}
