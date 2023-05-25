package by.tms.springstore.service.impl;

import by.tms.springstore.model.Category;
import by.tms.springstore.repository.CategoryRepository;
import by.tms.springstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAllCategory();
//        return categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id);
//        return categoryRepository.getCategory(id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return null;
    }
}
