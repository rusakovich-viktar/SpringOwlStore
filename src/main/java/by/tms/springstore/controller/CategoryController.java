package by.tms.springstore.controller;

import by.tms.springstore.domain.Category;
import by.tms.springstore.domain.Product;
import by.tms.springstore.service.ProductService;
import by.tms.springstore.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.tms.springstore.utils.Constants.Attributes.CURRENT_PAGE;
import static by.tms.springstore.utils.Constants.Attributes.NAME_CATEGORY;
import static by.tms.springstore.utils.Constants.Attributes.PRODUCTS;
import static by.tms.springstore.utils.Constants.Attributes.TOTAL_ITEMS;
import static by.tms.springstore.utils.Constants.Attributes.TOTAL_PAGES;
import static by.tms.springstore.utils.Constants.PagePath.CATEGORY;
import static by.tms.springstore.utils.Constants.RequestParams.PAGE;
import static by.tms.springstore.utils.Constants.RequestParams.SIZE;
import static by.tms.springstore.utils.Constants.VariableValues.PAGE_NUMBER_REQUESTED;
import static by.tms.springstore.utils.Constants.VariableValues.SIZE_OF_THE_ELEMENTS_ON_THE_PAGE;

@Controller
@RequiredArgsConstructor

public class CategoryController {

    private final ProductService productService;

//    без пагинации
//    @GetMapping("/category/{categoryId}")
//    public ModelAndView showCategories
//            (@PathVariable("categoryId") Long categoryId,
//             HttpServletRequest request, ModelAndView modelAndView) {
//        String nameCategory = request.getParameter(Constants.RequestParams.NAME_CATEGORY);
//        List<Product> categoryProducts = productService.getAllProductsByCategoryId(categoryId);
//        modelAndView.addObject(PRODUCTS, categoryProducts);
//        modelAndView.addObject(NAME_CATEGORY, nameCategory);
//        modelAndView.setViewName(CATEGORY);
//        return modelAndView;
//    }

    @GetMapping("/category/{categoryId}/{nameCategory}")
    public ModelAndView showCategoriesWithPagination(
            @PathVariable("categoryId") Long categoryId,
            @PathVariable("nameCategory") String nameCategory,
            @RequestParam(value = PAGE, defaultValue = PAGE_NUMBER_REQUESTED) int page,
            @RequestParam(value = SIZE, defaultValue = SIZE_OF_THE_ELEMENTS_ON_THE_PAGE) int size,
            ModelAndView modelAndView) {
        Page<Product> categoryProductsPage = productService.getAllProductsByCategoryId(categoryId, PageRequest.of(page, size));
        List<Product> categoryProducts = categoryProductsPage.getContent();

        modelAndView.addObject(PRODUCTS, categoryProducts);
        modelAndView.addObject(NAME_CATEGORY, nameCategory);
//        modelAndView.addObject(CATEGORY_ID, categoryId);
        modelAndView.addObject(CURRENT_PAGE, page);
        modelAndView.addObject(TOTAL_PAGES, categoryProductsPage.getTotalPages());
        modelAndView.addObject(TOTAL_ITEMS, categoryProductsPage.getTotalElements());
        modelAndView.setViewName(CATEGORY);

        return modelAndView;
    }

}