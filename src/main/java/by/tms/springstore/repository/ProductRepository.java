package by.tms.springstore.repository;

import by.tms.springstore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();
    //        List<Product> getProducts ();

    Product findById(Long id);
    //    Product getProductById(int id);

    List<Product> findByIdIn(Iterable<Long> ids);


    List<Product> findAllByCategoryId(Long categoryId);
    //    List<Product> getProductsByCategoryId(int categoryId);
}
