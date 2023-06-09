package by.tms.springstore.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@RequiredArgsConstructor
public class SpringConfig implements WebMvcConfigurer {
////    private final Environment environment;

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/home");
        registry.addRedirectViewController("", "/home");
    }

}
