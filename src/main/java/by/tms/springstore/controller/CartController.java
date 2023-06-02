package by.tms.springstore.controller;

import by.tms.springstore.domain.Cart;
import by.tms.springstore.domain.Product;
import by.tms.springstore.service.CartService;
import by.tms.springstore.utils.Constants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@SessionAttributes({Constants.Attributes.CART})
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add")
    public ModelAndView addProductToCart(@RequestParam(Constants.RequestParams.PRODUCT_ID) String id, @ModelAttribute(Constants.Attributes.CART) Cart shopCart) {
        int productId = Integer.parseInt(id);
        return cartService.addProductToCart(productId, shopCart);
    }

    @GetMapping("/show")
    public ModelAndView redirectToShoppingCart() {
        return new ModelAndView(Constants.PagePath.CART);
    }

    @ModelAttribute(Constants.Attributes.CART)
    public Cart shoppingCart() {
        return new Cart();
    }

//    @GetMapping("/cart")
//    public ModelAndView getCart() {
//        Cart cart = cartService.getCart();
//        ModelAndView modelAndView = new ModelAndView("cart");
//        modelAndView.addObject("cart", cart);
//        return modelAndView;
//    }


}
