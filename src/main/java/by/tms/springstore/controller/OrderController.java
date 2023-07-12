package by.tms.springstore.controller;

import static by.tms.springstore.utils.Constants.Attributes.ORDERS;
import static by.tms.springstore.utils.Constants.PagePath.ORDERS_PAGE;
import static by.tms.springstore.utils.Constants.PagePath.REDIRECT_TO_HOME;

import by.tms.springstore.domain.Order;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDto;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.OrderService;
import by.tms.springstore.service.UserService;
import java.security.Principal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final CartService cartService;
    private final UserService userService;

    @PostMapping("/create")
    public String createOrder(Authentication authentication) {
        User user = orderService.getCurrentUser(authentication);
        CartDto cartDto = cartService.getCartByUsername(user.getUsername());
        Order order = orderService.createOrder(cartDto, user);
        orderService.saveOrder(order, cartDto.getCartDetails());
        orderService.deleteCartAfterBuy(user);
        return REDIRECT_TO_HOME;
    }

    @GetMapping("/show")
    public ModelAndView getUserOrders(Principal principal, ModelAndView modelAndView) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        List<Order> orders = orderService.findByUser(user);
        modelAndView.addObject(ORDERS, orders).setViewName(ORDERS_PAGE);
        return modelAndView;
    }

}
