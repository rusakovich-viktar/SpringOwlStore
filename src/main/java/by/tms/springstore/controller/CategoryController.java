package by.tms.springstore.controller;

import by.tms.springstore.domain.Product;
import by.tms.springstore.service.ProductService;
import by.tms.springstore.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.tms.springstore.utils.Constants.Attributes.CATEGORY_ID;
import static by.tms.springstore.utils.Constants.Attributes.NAME_CATEGORY;
import static by.tms.springstore.utils.Constants.Attributes.PRODUCTS;
import static by.tms.springstore.utils.Constants.PagePath.CATEGORY;

@Controller
@RequiredArgsConstructor

public class CategoryController {

    private final ProductService productService;

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

    @GetMapping("/category/{categoryId}")
    public ModelAndView showCategoriesWithPagination(
            @PathVariable("categoryId") Long categoryId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "3") int size,
//            HttpServletRequest request,
            ModelAndView modelAndView) {
//        String nameCategory = request.getParameter(Constants.RequestParams.NAME_CATEGORY);

        Page<Product> categoryProductsPage = productService.getAllProductsByCategoryId(categoryId, PageRequest.of(page, size));
        List<Product> categoryProducts = categoryProductsPage.getContent();

        modelAndView.addObject(PRODUCTS, categoryProducts);
//        modelAndView.addObject(NAME_CATEGORY, nameCategory);
//        modelAndView.addObject(CATEGORY_ID, categoryId);
        modelAndView.addObject("currentPage", page);
        modelAndView.addObject("totalPages", categoryProductsPage.getTotalPages());
        modelAndView.addObject("totalItems", categoryProductsPage.getTotalElements());
        modelAndView.setViewName(CATEGORY);

        return modelAndView;
    }

}