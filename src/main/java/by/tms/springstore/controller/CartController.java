//package by.tms.springstore.controller;
//
//import by.tms.springstore.dto.UserDto;
//import by.tms.springstore.model.Cart;
//import by.tms.springstore.model.Product;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.math.BigDecimal;
//
//import static by.tms.springstore.utils.Constants.Attributes.CART;
//import static by.tms.springstore.utils.Constants.Attributes.MY_PRODUCTS;
//import static by.tms.springstore.utils.Constants.Attributes.ONE_PRODUCT;
//import static by.tms.springstore.utils.Constants.Attributes.TOTAL_PRICE;
//import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
//import static by.tms.springstore.utils.Constants.RequestParams.ACTION;
//import static by.tms.springstore.utils.Constants.RequestParams.CATEGORY_ID;
//import static by.tms.springstore.utils.Constants.RequestParams.DESCRIPTION;
//import static by.tms.springstore.utils.Constants.RequestParams.ID;
//import static by.tms.springstore.utils.Constants.RequestParams.IMAGE_NAME;
//import static by.tms.springstore.utils.Constants.RequestParams.NAME;
//import static by.tms.springstore.utils.Constants.RequestParams.PRICE_PARAMETER;
//import static by.tms.springstore.utils.Utils.isUserLogIn;
//
//@RequestMapping("/cart")
//@Controller
//@RequiredArgsConstructor
//@Slf4j
//public class CartController {
//
//    @GetMapping("/show")
//    public ModelAndView showProductInCart(HttpServletRequest request, ModelAndView modelAndView) {
//        HttpSession session = request.getSession(); //+
//        UserDto userDto = (UserDto) session.getAttribute(USER_DTO); //+
//        if (isUserLogIn(userDto)) { //+
//            Cart cart = (Cart) session.getAttribute(CART);
//            if (cart == null) {
//                cart = new Cart();
//                session.setAttribute(CART, cart);
//            }
//            BigDecimal totalPrice = cart.getTotalPrice();
//            modelAndView.addObject(CART, cart);
//            modelAndView.addObject(TOTAL_PRICE, totalPrice);
//            modelAndView.setViewName("cart"); //+
//        } else {
//            modelAndView.setViewName("signin"); //+
//        }
//        return modelAndView; //+
//    }
//
//    @PostMapping("/add")
//    public ModelAndView addProductToCart(
//            HttpServletRequest request, ModelAndView modelAndView) {
//        HttpSession session = request.getSession(false);
//        Cart cart = (Cart) session.getAttribute(CART);
//        int id = Integer.parseInt(request.getParameter(ID));
//        String imageName = request.getParameter(IMAGE_NAME);
//        String name = request.getParameter(NAME);
//        String description = request.getParameter(DESCRIPTION);
//        String priceParameter = request.getParameter(PRICE_PARAMETER);
//        int categoryId = Integer.parseInt(request.getParameter(CATEGORY_ID));
//        BigDecimal price = new BigDecimal(priceParameter);
//        Product product = new Product(id, imageName, name, description, price, categoryId);
//        String action = request.getParameter(ACTION);
//        if ("Buy".equals(action)) {
//            cart.addProduct(product);
//            session.setAttribute(MY_PRODUCTS, cart.getProducts());
//            request.setAttribute(ONE_PRODUCT, product);
//            modelAndView.setViewName("product");
//        } else if ("Delete".equals(action)) {
//            cart.deleteProduct(product);
//            session.setAttribute(MY_PRODUCTS, cart.getProducts());
//            modelAndView.setViewName("cart");
//        } else {
//            log.error("Такой кнопки нет");
//        }
//        return modelAndView;
//    }
//
//}
