package by.tms.springstore.service.impl;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.Product;
import by.tms.springstore.domain.User;
import by.tms.springstore.dto.CartDetailDto;
import by.tms.springstore.dto.CartDto;
import by.tms.springstore.exceptions.ProductNotFoundException;
import by.tms.springstore.repository.CartRepository;
import by.tms.springstore.repository.ProductRepository;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserService userService;

    @Override
    @jakarta.transaction.Transactional
    public Cart createCart(User user, List<Long> productIds) {
        Cart cart = new Cart();
        cart.setUser(user);
        List<Product> productList = getCollectRefProductsByIds(productIds);
        cart.setProducts(productList);
        return cartRepository.save(cart);
    }

    public List<Product> getCollectRefProductsByIds(List<Long> productIds) {
        List<Product> products = productRepository.findByIdIn(productIds);
        if (products.size() != productIds.size()) {
            throw new ProductNotFoundException("Some products were not found");
        }
        return products;
    }

    @Override
    public void addProducts(Cart cart, List<Long> productIds) {

    }

    @Override
    public CartDto getCartByUsername(String username) {
        User user = userService.findByUsername(username);
        if (user == null || user.getCart() == null) {
            return new CartDto();
        }
        CartDto cartDto = new CartDto();
        Map<Long, CartDetailDto> mapByProductId = new HashMap<>();

        List<Product> products = user.getCart().getProducts();
        for (Product product : products) {
            CartDetailDto detail = mapByProductId.get(product.getId());
            if (detail == null) {
                mapByProductId.put(product.getId(), new CartDetailDto(product));
            } else {
                detail.setAmount(detail.getAmount() + 1.0);
                detail.setSum(detail.getSum().add(product.getPrice()));
            }
        }

        cartDto.setCartDetails(new ArrayList<>(mapByProductId.values()));
        cartDto.aggregate();

        return cartDto;
    }

    @Override
    public void commitCartToOrder(String username) {

    }
}
