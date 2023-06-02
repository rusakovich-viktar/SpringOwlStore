//package by.tms.springstore.service;
//
//import by.tms.springstore.domain.Cart;
//import by.tms.springstore.domain.Product;
//import by.tms.springstore.repository.ProductRepository;
//import by.tms.springstore.utils.Constants;
//import org.springframework.stereotype.Service;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.Optional;
//
//import static by.tms.springstore.utils.Constants.Attributes.CART;
//import static by.tms.springstore.utils.Constants.Attributes.PRODUCT;
//
//@Service
//public class CartService {
//    private final ProductRepository productRepository;
//
//    public CartService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    public ModelAndView addProductToCart(Long productId, Cart shopCart) {
//        ModelMap modelParams = new ModelMap();
//
//        Optional<Product> product = productRepository.findById(productId);
//        if (product != null) {
//            shopCart.addProduct(product);
//        }
//        modelParams.addAttribute(PRODUCT, product);
//        modelParams.addAttribute(CART, shopCart);
//
//        return new ModelAndView(Constants.PagePath.CART, modelParams);
//    }
//}