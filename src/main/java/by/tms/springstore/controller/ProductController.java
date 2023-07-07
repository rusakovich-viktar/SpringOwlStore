package by.tms.springstore.controller;

import by.tms.springstore.domain.Product;
import by.tms.springstore.service.ProductService;
import by.tms.springstore.utils.Constants;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

import static by.tms.springstore.utils.Constants.VariableValues.MINIMUM_QUERY_LENGTH_TO_SEARCH;
import static by.tms.springstore.utils.Constants.Attributes.ONE_PRODUCT;
import static by.tms.springstore.utils.Constants.PagePath.PRODUCT;
import static by.tms.springstore.utils.Constants.PagePath.SEARCH_RESULTS;
import static by.tms.springstore.utils.Constants.RequestParams.PRODUCT_ID;
import static by.tms.springstore.utils.Constants.RequestParams.QUERY;

@RequiredArgsConstructor
@RequestMapping("/product")
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ModelAndView showProduct(@PathVariable Long productId,
                                    HttpServletRequest request, ModelAndView modelAndView) {
        Product product = productService.getProductById(productId);
        request.setAttribute(ONE_PRODUCT, product);
        modelAndView.setViewName(PRODUCT);
        return modelAndView;
    }


    @PostMapping("/add")
    public ModelAndView addCart(@RequestParam(PRODUCT_ID) Long productId, Principal principal, ModelAndView modelAndView) {
        productService.addToUserCart(productId, principal.getName());
        modelAndView.setViewName("redirect:/product/" + productId + "?added=true");
        return modelAndView;
    }


    @GetMapping("/search")
    public ModelAndView searchProducts(@RequestParam("query") String query, ModelAndView modelAndView) {
        modelAndView.setViewName("search-results");
        if (query.length() >= MINIMUM_QUERY_LENGTH_TO_SEARCH) {
            List<Product> searchResults = productService.searchProducts(query);
            modelAndView.addObject("searchResults", searchResults);
        }
        return modelAndView;
    }
}