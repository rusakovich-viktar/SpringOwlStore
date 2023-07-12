package by.tms.springstore.service;

import by.tms.springstore.domain.Order;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDetailDto;
import by.tms.springstore.dto.CartDto;
import java.util.List;
import org.springframework.security.core.Authentication;

public interface OrderService {

    Order createOrder(CartDto cartDto, User user);

    void saveOrder(Order order, List<CartDetailDto> cartDetailDtos);

    void deleteCartAfterBuy(User user);

    User getCurrentUser(Authentication authentication);

    List<Order> findByUser(User user);

}
