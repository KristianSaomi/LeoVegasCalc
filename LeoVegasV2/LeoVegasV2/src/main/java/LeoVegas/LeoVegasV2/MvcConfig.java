package LeoVegas.LeoVegasV2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/Home").setViewName("Home");
        registry.addViewController("/register_success").setViewName("register_success");
        registry.addViewController("/playScreen").setViewName("playScreen");
        registry.addViewController("/registerUser").setViewName("registerUser");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/personalData").setViewName("personalData");
        registry.addViewController("/account/save").setViewName("/account/save");
        registry.addViewController("/newAccount").setViewName("/newAccount");
        registry.addViewController("/users").setViewName("/users");
        registry.addViewController("/addNewDebitAccount").setViewName("/addNewDebitAccount");
    }
}
