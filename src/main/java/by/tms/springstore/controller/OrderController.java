package by.tms.springstore.controller;

import by.tms.springstore.domain.Order;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDto;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final CartService cartService;
    private final UserRepository userRepository;

    @PostMapping("/create")
    public String createOrder() {
        // Получаем текущего пользователя
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));

        CartDto cartDto = cartService.getCartByUsername(user.getUsername());
        Order order = orderService.createOrder(cartDto, user);
        orderService.saveOrder(order, cartDto.getCartDetails());
        orderService.deleteCartAfterBuy(user);
        return "redirect:/home";
    }


//    @Override
//    @Transactional
//    public List<OrderDto> getAll() {
//        return orderMapper.ordersEntityToDto(orderRepository.findAll());
//    }


}




