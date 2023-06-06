package by.tms.springstore.controller;

import by.tms.springstore.dto.CartDto;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @GetMapping("/show")
    public String aboutCart(Model model, HttpSession session/*, Principal principal*/) {
        UserDto userDto = (UserDto) session.getAttribute(USER_DTO);
        /*if (principal == null) {
            model.addAttribute("cart", new CartDto());
        } else {*/
            CartDto cartDto = cartService.getCartByUsername(userDto.getUsername());
            model.addAttribute("cart", cartDto);
//        }
        return "cart";
    }

    @PostMapping()
    public String commitCart(Principal principal) {
        if (principal != null) {
            cartService.commitCartToOrder(principal.getName());
        }
        return "redirect:/cart";
    }

}
