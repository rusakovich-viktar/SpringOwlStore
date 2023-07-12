package by.tms.springstore.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.User;
import by.tms.springstore.exceptions.UserNotFoundException;
import by.tms.springstore.service.CartService;
import by.tms.springstore.service.ProductService;
import by.tms.springstore.service.UserService;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;

    @MockBean
    private CartService cartService;

    @MockBean
    private UserService userService;

    @Nested
    class TestAddToUserCart {
        private String username = "TestUser";
        private long cardId = 1L;

        @Test
        void test_addToUserCart_ifCartNull() {

            User user = new User();
            user.setUsername(username);
            user.setCart(null);
            Cart cart = new Cart();
            //when
            when(userService.findByUsername(username)).thenReturn(user);
            when(cartService.createCart(eq(user), any())).thenReturn(cart);
            doNothing().when(userService).save(user);

            productService.addToUserCart(cardId, username);
            //then
            verify(userService, atLeastOnce()).findByUsername(username);
            verify(cartService, atLeastOnce()).createCart(eq(user), any());
            verify(userService, atLeastOnce()).save(user);
            verify(cartService, never()).addProducts(eq(cart), any());
        }

        @Test
        void test_addToUserCart_ifUserIsNotExist() {
            when(userService.findByUsername(username)).thenReturn(null);

            assertThrows(UserNotFoundException.class, () -> productService.addToUserCart(cardId, username));

        }

        @Test
        void test_addToUserCart_ifCartNotNull() {
//            дано
            User user = new User();
            user.setUsername(username);
            Cart cart = new Cart();
            user.setCart(cart);
            //when
            when(userService.findByUsername(username)).thenReturn(user);
            doNothing().when(cartService).addProducts(eq(cart), any());

            productService.addToUserCart(cardId, username);
            //then
            verify(userService, atLeastOnce()).findByUsername(username);
            verify(cartService, never()).createCart(eq(user), any());
            verify(userService, never()).save(user);
            verify(cartService, atLeastOnce()).addProducts(eq(cart), any());
        }

    }
}