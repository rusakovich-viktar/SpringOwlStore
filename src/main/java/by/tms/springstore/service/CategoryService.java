package by.tms.springstore.service;

import by.tms.springstore.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategoryById(Long id);

    Category getCategoryByName(String name);
}
