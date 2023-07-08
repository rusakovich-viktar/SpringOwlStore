package by.tms.springstore.repository;

import by.tms.springstore.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findById(Long id);

    List<Product> findByIdIn(Iterable<Long> ids);

    List<Product> findAllByCategoryId(Long categoryId);

    List<Product> findByNameContainingIgnoreCase(String query);

    Page<Product> findAllByCategoryId(Long categoryId, Pageable pageable);
}
