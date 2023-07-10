package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Category;
import by.tms.springstore.repository.CategoryRepository;
import by.tms.springstore.service.CategoryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAllCategories();
    }

}
