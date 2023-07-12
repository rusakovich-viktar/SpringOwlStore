package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Order;
import by.tms.springstore.domain.Product;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDetailDto;
import by.tms.springstore.dto.CartDto;
import by.tms.springstore.repository.OrderRepository;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.OrderService;
import by.tms.springstore.service.ProductService;
import by.tms.springstore.service.UserService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final UserService userService;
    private final ProductService productService;

//    @Override
    public User getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        return userService.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderRepository.findByUser(user);
    }

    @Override
    public Order createOrder(CartDto cartDto, User user) {
        Order order = Order.builder()
                .sum(cartDto.getSum())
                .user(user)
                .date(LocalDateTime.now())
                .build();
        return orderRepository.save(order);
    }

    @Transactional
    @Override
    public void saveOrder(Order order, List<CartDetailDto> cartDetailDtos) {
        List<Product> products = new ArrayList<>();
        for (CartDetailDto cartDetailDto : cartDetailDtos) {
            products.add(productService.getProductById(cartDetailDto.getProductId()));
        }
        order.setProducts(products);
    }

    @Override
    public void deleteCartAfterBuy(User user) {
        cartService.delete(user);
    }

}
