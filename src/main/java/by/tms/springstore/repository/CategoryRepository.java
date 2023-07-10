package by.tms.springstore.repository;

import by.tms.springstore.domain.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("from Category")
    List<Category> findAllCategories();

}
