package by.tms.springstore.repository;

import by.tms.springstore.domain.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(Long id);

    List<Product> findByIdIn(Iterable<Long> ids);

    List<Product> findByNameContainingIgnoreCase(String query);

    Page<Product> findAllByCategoryId(Long categoryId, Pageable pageable);
}
