package by.tms.springstore.service;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CartService {
    Cart createCart(User user, List<Long> productIds);

    void addProducts(Cart cart, List<Long> productIds);

    CartDto getCartByUsername(String username);

    void commitCartToOrder(String username);


    void deleteProduct(Cart cart, List<Long> productIds);
}
