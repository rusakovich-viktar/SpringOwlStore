package by.tms.springstore.controller;

import by.tms.springstore.domain.Product;
import by.tms.springstore.dto.UserDto;

import by.tms.springstore.service.ProductService;
import by.tms.springstore.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.tms.springstore.utils.Constants.Attributes.PRODUCTS;
import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Constants.RequestParams.CATEGORY_ID;
import static by.tms.springstore.utils.Constants.RequestParams.NAME_CATEGORY;
import static by.tms.springstore.utils.Constants.RequestParams.PRODUCT_ID;
import static by.tms.springstore.utils.Utils.isUserLogIn;

@Controller
@RequiredArgsConstructor

public class CategoryController {

    private final ProductService productService;

    @GetMapping("/category/{categoryId}")
    public ModelAndView showCategories
            (@PathVariable Long categoryId,
            /*@RequestParam(CATEGORY_ID) long categoryId,
                                       @RequestParam(Constants.RequestParams.NAME_CATEGORY) String nameCategory,*/
                                       HttpServletRequest request, ModelAndView modelAndView) {
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute(USER_DTO);
        if (isUserLogIn(userDto)) {
            String nameCategory = request.getParameter(NAME_CATEGORY);

            List<Product> categoryProducts = productService.getAllProductsByCategoryId(categoryId);
            modelAndView.addObject(PRODUCTS, categoryProducts);
            modelAndView.addObject(Constants.Attributes.NAME_CATEGORY, nameCategory);
            modelAndView.setViewName("category");
        } else {
            modelAndView.setViewName("signin");
        }
        return modelAndView;
    }

}