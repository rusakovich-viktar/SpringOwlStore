package by.tms.springstore.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class HelloController {

//    private final AdminService adminService;

    @GetMapping("/hello")
    public String sayHello() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(authentication);

        return "hello";
    }

    @GetMapping("/show")
    public String showUserInfo() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();
//        System.out.println("personDetails::::: " + personDetails);
//
//        System.out.println("authentication::::: " + authentication);
        return "hello";
    }


    @GetMapping("/admin")
    public String adminPage() {
//        adminService.doAdminStuff();
        return "admin";
    }
    @GetMapping("/open")
    public String openPage() {
        return "open";
    }
}
