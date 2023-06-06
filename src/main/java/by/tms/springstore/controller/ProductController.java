package by.tms.springstore.controller;

import by.tms.springstore.domain.Product;
import by.tms.springstore.dto.UserDto;
import by.tms.springstore.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Optional;

import static by.tms.springstore.utils.Constants.Attributes.ONE_PRODUCT;
import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;
import static by.tms.springstore.utils.Constants.RequestParams.PRODUCT_ID;
import static by.tms.springstore.utils.Utils.isUserLogIn;

@RequiredArgsConstructor
@RequestMapping("/product")
@Controller
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{productId}")
    public ModelAndView showProduct(@PathVariable Long productId,
            HttpServletRequest request, ModelAndView modelAndView) {
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute(USER_DTO);
        if (isUserLogIn(userDto)) {
//            long productId = Long.parseLong(request.getParameter(PRODUCT_ID));
            Product product = productService.getProductById(productId);
            request.setAttribute(ONE_PRODUCT, product);
            modelAndView.setViewName("product");
        } else {
            modelAndView.setViewName("signin");
        }
        return modelAndView;
    }


    @GetMapping("/{id}/card")
    public String addCart(@PathVariable Long id, HttpSession session /*, Principal principal*/) {
        UserDto userDto = (UserDto) session.getAttribute(USER_DTO);
        /*  sessionObjectHolder.addClick();
        if(principal == null){
            return "redirect:/product";
        }*/
        productService.addToUserCart(id, userDto.getUsername());
        return "redirect:/product";
    }

}
