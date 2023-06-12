package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.Product;
import by.tms.springstore.domain.User;
import by.tms.springstore.repository.ProductRepository;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.ProductService;
import by.tms.springstore.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Setter
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CartService cartService;


    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProductsByCategoryId(Long categoryId) {
        return productRepository.findAllByCategoryId(categoryId);
    }

    @Override
    @Transactional
    public void addToUserCart(Long productId, String username) {
        User user = getUser(username);
        Cart cart = user.getCart();
        if (cart == null) {
            Cart newCart = cartService.createCart(user, Collections.singletonList(productId));
            user.setCart(newCart);
            userService.save(user);
        } else {
            cartService.addProducts(cart, Collections.singletonList(productId));
        }
    }

    @NotNull
    private User getUser(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new RuntimeException("User not found. " + username);
        }
        return user;
    }

    @Override
    @Transactional
    public void removeAllIdenticalProductsFromUserCart(Long productId, String username) {
        User user = getUser(username);
        Cart cart = user.getCart();
        if (cart != null) {
            cartService.deleteAllIdenticalProduct(cart, Collections.singletonList(productId));
        }
    }

    @Override
    @Transactional
    public void removeOneIdenticalProductFromUserCart(Long productId, String username) {
        User user = getUser(username);
        Cart cart = user.getCart();
        if (cart != null) {
            cartService.deleteOneProduct(cart, Collections.singletonList(productId));
        }

    }


}
