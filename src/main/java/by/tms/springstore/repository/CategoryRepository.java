package by.tms.springstore.repository;

import by.tms.springstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("from Category")
    List<Category> findAllCategories();

}
