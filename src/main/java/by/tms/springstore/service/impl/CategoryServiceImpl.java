package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Category;
import by.tms.springstore.repository.CategoryRepository;
import by.tms.springstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAllCategories();
//        return categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
//        return categoryRepository.getCategory(id);

    @Override
    public Category getCategoryByName(String name) {
        return null;
    }
}
