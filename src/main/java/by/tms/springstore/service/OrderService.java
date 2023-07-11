package by.tms.springstore.service;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.Order;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDetailDto;
import by.tms.springstore.dto.CartDto;
import by.tms.springstore.dto.UserDto;
import jakarta.transaction.Transactional;
import java.util.List;

public interface OrderService {

//    void createOrder(CartDto cart, String username);

//    void createOrderd(CartDto cartDto, User user);


    Order createOrder(CartDto cartDto, User user);

    void saveOrder(Order order, List<CartDetailDto> cartDetailDtos);

    void deleteCartAfterBuy(User user);

//    void createOrderFromCart(CartDto cart);
}
