package by.tms.springstore.controller;

import static by.tms.springstore.utils.Constants.Attributes.CONTACT_FORM;
import static by.tms.springstore.utils.Constants.Attributes.MESSAGE_SEND_SUCCESS;
import static by.tms.springstore.utils.Constants.Attributes.SUCCESS_MESSAGE;
import static by.tms.springstore.utils.Constants.PagePath.ABOUT_US;
import static by.tms.springstore.utils.Constants.PagePath.AUTH_USER_AGREEMENT;
import static by.tms.springstore.utils.Constants.PagePath.CONTACTS;

import by.tms.springstore.dto.UserDtoFromContactForm;
import by.tms.springstore.service.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class OtherPagesController {

    private final EmailService emailService;

    @GetMapping("/user-agreement")
    public ModelAndView userAgreementPage() {
        return new ModelAndView(AUTH_USER_AGREEMENT);
    }

    @GetMapping("/contacts")
    public ModelAndView showContacts() {
        ModelAndView modelAndView = new ModelAndView(CONTACTS);
        modelAndView.addObject(CONTACT_FORM, new UserDtoFromContactForm());
        return modelAndView;
    }

    @PostMapping("/contact-form")
    public ModelAndView sendContactForm(@ModelAttribute(CONTACT_FORM) @Valid UserDtoFromContactForm userDtoFromContactForm, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView(CONTACTS);
        if (result.hasErrors()) {
            modelAndView.addObject(CONTACT_FORM, userDtoFromContactForm);
        } else {
            emailService.sendContactForm(userDtoFromContactForm);
            modelAndView.addObject(SUCCESS_MESSAGE, MESSAGE_SEND_SUCCESS);
        }
        return modelAndView;
    }

    @GetMapping("/about-us")
    public ModelAndView showAboutUsInfo() {
        return new ModelAndView(ABOUT_US);
    }
}
