package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.Order;
import by.tms.springstore.domain.Product;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDetailDto;
import by.tms.springstore.dto.CartDto;
import by.tms.springstore.mapper.ProductMapper;
import by.tms.springstore.mapper.UserMapper;
import by.tms.springstore.repository.OrderRepository;
import by.tms.springstore.repository.ProductRepository;
import by.tms.springstore.repository.UserRepository;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.OrderService;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final ProductMapper productMapper;
    private final UserMapper userMapper;


    @Override
    public Order createOrder(CartDto cartDto, User user) {

        Order order = Order.builder()
                .sum(cartDto.getSum())
                .user(user)
                .date(LocalDateTime.now())
                .build();

        Order createdOrder = orderRepository.save(order);
        return createdOrder;
    }

    @Transactional
    @Override
    public void saveOrder(Order order, List<CartDetailDto> cartDetailDtos) {
        List<Product> products = new ArrayList<>();
        for (CartDetailDto cartDetailDto : cartDetailDtos) {
            products.add(productRepository.findById(cartDetailDto.getProductId()));
        }
        order.setProducts(products);
    }

    @Override
    public void deleteCartAfterBuy(User user) {
        cartService.delete(user);
    }

//        public void saveOrder(Order order)
//orderRepository.save(createdOrder)
}
