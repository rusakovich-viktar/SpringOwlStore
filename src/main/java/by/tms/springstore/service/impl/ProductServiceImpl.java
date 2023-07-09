package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.Product;
import by.tms.springstore.domain.User;
import by.tms.springstore.exceptions.UserNotFoundException;
import by.tms.springstore.repository.ProductRepository;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.ProductService;
import by.tms.springstore.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static by.tms.springstore.utils.Constants.Attributes.NOT_FOUND;

@Setter
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;
    private final CartService cartService;

    public Product getProductById(Long id) {
        return productRepository.findById(id);
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

    private User getUser(String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User " + username + NOT_FOUND);
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

    @Override
    public List<Product> searchProducts(String query) {
        return productRepository.findByNameContainingIgnoreCase(query);
    }

    @Override
    public Page<Product> getAllProductsByCategoryId(Long categoryId, Pageable pageable) {
        return productRepository.findAllByCategoryId(categoryId, pageable);
    }

}
