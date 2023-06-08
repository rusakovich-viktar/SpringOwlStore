package by.tms.springstore.controller;

import by.tms.springstore.dto.CartDto;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
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
    public String showCart(Model model, HttpSession session/*, Principal principal*/) {
        UserDto userDto = (UserDto) session.getAttribute(USER_DTO);
        /*if (principal == null) {
            model.addAttribute("cart", new CartDto());
        } else {*/
        CartDto cartDto = cartService.getCartByUsername(userDto.getUsername());
        model.addAttribute("cart", cartDto);
//        }
        return "cart";
    }

    @GetMapping("/{productId}/delete")
    public String deleteProductFromCart(@PathVariable Long productId, Model model, HttpSession session) {
        UserDto userDto = (UserDto) session.getAttribute(USER_DTO);
        productService.removeFromUserCart(productId, userDto.getUsername());
        return "redirect:/cart";
//        return "redirect:/product/" + productId;
    }


    @PostMapping()
    public String commitCart(Principal principal) {
        if (principal != null) {
            cartService.commitCartToOrder(principal.getName());
        }
        return "redirect:/cart";
    }

}
