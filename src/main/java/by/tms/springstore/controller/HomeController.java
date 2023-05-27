package by.tms.springstore.controller;

import by.tms.springstore.dto.UserDto;
import by.tms.springstore.domain.Category;
import by.tms.springstore.service.CategoryService;
import by.tms.springstore.utils.Utils;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.tms.springstore.utils.Constants.Attributes.CATEGORIES;
import static by.tms.springstore.utils.Constants.Attributes.USER_DTO;

@RequiredArgsConstructor
@Controller
public class HomeController {

    private final CategoryService categoryService;

    @GetMapping("/home")
    public ModelAndView getHomePage(@NotNull HttpSession session, ModelAndView modelAndView) {
        UserDto userDto = (UserDto) session.getAttribute(USER_DTO);
        if (Utils.isUserLogIn(userDto)) {
            List<Category> categories = categoryService.getCategories();
            modelAndView.addObject(CATEGORIES, categories);
            modelAndView.setViewName("home");
        } else {
            modelAndView.setViewName("signin");
        }
        return modelAndView;
    }
}