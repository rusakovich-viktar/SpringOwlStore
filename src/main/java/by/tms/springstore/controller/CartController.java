package by.tms.springstore.controller;

import by.tms.springstore.dto.CartDto;
import by.tms.springstore.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/cart")
    public String aboutCart(Model model, Principal principal){
        if(principal == null){
            model.addAttribute("cart", new CartDto());
        }
        else {
            CartDto cartDto = cartService.getCartByUser(principal.getName());
            model.addAttribute("cart", cartDto);
        }

        return "cart";
    }

    @PostMapping("/cart")
    public String commitCart(Principal principal){
        if(principal != null){
            cartService.commitCartToOrder(principal.getName());
        }
        return "redirect:/cart";
    }

}
