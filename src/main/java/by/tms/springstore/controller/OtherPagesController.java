package by.tms.springstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OtherPagesController {

    @GetMapping("/user-agreement")
    public ModelAndView userAgreementPage() {
        return new ModelAndView("auth/user-agreement");
    }
}
