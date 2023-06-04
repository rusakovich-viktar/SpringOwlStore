package by.tms.springstore.service;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDto;

import java.util.List;

public interface CartService {
    Cart createCart(User user, List<Long> productIds);

    void addProducts(Cart cart, List<Long> productIds);

    CartDto getCartByUser(String name);

    void commitCartToOrder(String username);



}
