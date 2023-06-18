package by.tms.springstore.controller;

import by.tms.springstore.domain.Product;
import by.tms.springstore.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.tms.springstore.utils.Constants.Attributes.ONE_PRODUCT;
import static by.tms.springstore.utils.Constants.PagePath.PRODUCT;
import static by.tms.springstore.utils.Constants.PagePath.REDIRECT_TO_PRODUCT;

@RequiredArgsConstructor
@RequestMapping("/product")
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ModelAndView showProduct(@PathVariable("productId") Long productId,
                                    HttpServletRequest request, ModelAndView modelAndView) {
        Product product = productService.getProductById(productId);
        request.setAttribute(ONE_PRODUCT, product);
        modelAndView.setViewName(PRODUCT);
        return modelAndView;
    }


    @GetMapping("/{productId}/add") ///POST
    public String addCart(@PathVariable("productId") Long productId, Authentication authentication) {
        productService.addToUserCart(productId, authentication.getName());
        return REDIRECT_TO_PRODUCT + "/" + productId;
    }

    @GetMapping("/search")
    public ModelAndView searchProducts(@RequestParam("query") String query, ModelAndView modelAndView) {
        List<Product> searchResults = productService.searchProducts(query);
        modelAndView.addObject("searchResults", searchResults);
        modelAndView.setViewName("search-results");
        return modelAndView;
    }
}
