package by.tms.springstore.controller;

import by.tms.springstore.dto.ContactForm;
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
        return new ModelAndView("auth/user-agreement");
    }

    @GetMapping("/contacts")
    public ModelAndView showContacts() {
        ModelAndView modelAndView = new ModelAndView("contacts.html");
        modelAndView.addObject("contactForm", new ContactForm());
        return modelAndView;
    }

    @PostMapping("/contact-form")
    public ModelAndView sendContactForm(@ModelAttribute("contactForm") @Valid ContactForm contactForm, BindingResult result) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("contacts.html");
        if (result.hasErrors()) {
            modelAndView.addObject("contactForm", contactForm);
        } else {
            emailService.sendContactForm(contactForm);
            modelAndView.addObject("successMessage", "Ваше сообщение успешно отправлено!");
        }
        return modelAndView;
    }

    @GetMapping("/about-us")
    public String showAboutUsInfo() {
        return "about-us";
    }
}
