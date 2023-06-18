package by.tms.springstore.controller;

import by.tms.springstore.dto.CartDto;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.ProductService;
import by.tms.springstore.utils.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import static by.tms.springstore.utils.Constants.PagePath.CART;
import static by.tms.springstore.utils.Constants.PagePath.REDIRECT_TO_CART;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping()
    public ModelAndView showCart(ModelAndView modelAndView, Principal principal) {
        CartDto cartDto = cartService.getCartByUsername(principal.getName());
        modelAndView.addObject(Constants.Attributes.CART, cartDto);
        modelAndView.setViewName(CART);
        return modelAndView;
    }

    @GetMapping("/delete/{productId}")
    public String deleteAllIdenticalProductsFromCart(@PathVariable("productId") Long productId, Authentication authentication) {
        productService.removeAllIdenticalProductsFromUserCart(productId, authentication.getName());
        return REDIRECT_TO_CART;
    }

    @GetMapping("/delete-one/{productId}")
    public String deleteOneIdenticalProductsFromCart(@PathVariable("productId") Long productId, Authentication authentication) {
        productService.removeOneIdenticalProductFromUserCart(productId, authentication.getName());
        return REDIRECT_TO_CART;
    }

    @GetMapping("/{productId}/add") ///POST
    public String addCart(@PathVariable("productId") Long productId, Principal principal) {
        productService.addToUserCart(productId, principal.getName());
        return REDIRECT_TO_CART;
    }

    @PostMapping()
    public String commitCart(Principal principal) {
        if (principal != null) {
            cartService.commitCartToOrder(principal.getName());
        }
        return REDIRECT_TO_CART;
    }
}
