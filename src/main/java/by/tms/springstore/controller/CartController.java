package by.tms.springstore.controller;

import by.tms.springstore.dto.CartDto;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping()
    public String showCart(Model model, Principal principal) {
        /*if (principal == null) {
            model.addAttribute("cart", new CartDto());
        } else {*/
        CartDto cartDto = cartService.getCartByUsername(principal.getName());
        model.addAttribute("cart", cartDto);
//        }
        return "cart";
    }

    @GetMapping("/delete/{productId}")
    public String deleteAllIdenticalProductsFromCart(@PathVariable Long productId, Authentication authentication) {
        productService.removeAllIdenticalProductsFromUserCart(productId, authentication.getName());
        return "redirect:/cart";
    }

    @GetMapping("/delete-one/{productId}")
    public String deleteOneIdenticalProductsFromCart(@PathVariable Long productId, Authentication authentication) {
        productService.removeOneIdenticalProductFromUserCart(productId, authentication.getName());
        return "redirect:/cart";
    }

    @GetMapping("/{productId}/add")
    public String addCart(@PathVariable Long productId, Principal principal) {
        productService.addToUserCart(productId, principal.getName());
        return "redirect:/cart";
    }

    @PostMapping()
    public String commitCart(Principal principal) {
        if (principal != null) {
            cartService.commitCartToOrder(principal.getName());
        }
        return "redirect:/cart";
    }
}
