package by.tms.springstore.controller;

import by.tms.springstore.domain.Product;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import static by.tms.springstore.utils.Constants.Attributes.ONE_PRODUCT;
import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Utils.isUserLogIn;

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
            modelAndView.setViewName("product");
        return modelAndView;
    }


    @GetMapping("/{productId}/add")
    public String addCart(@PathVariable Long productId, Authentication authentication) {
        productService.addToUserCart(productId, authentication.getName());
        return "redirect:/product/" + productId;
    }
}
