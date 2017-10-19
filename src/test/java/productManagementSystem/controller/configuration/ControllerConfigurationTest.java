package productManagementSystem.controller.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import productManagementSystem.service.ProductService;
import productManagementSystem.service.UserDetailedServiceImpl;
import productManagementSystem.service.UserService;

import static org.mockito.Mockito.mock;

@Configuration
public class ControllerConfigurationTest {

    @Bean
    public UserService userService(){
        return mock(UserService.class);
    }

    @Bean
    public ProductService productService(){
        return mock(ProductService.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return mock(PasswordEncoder.class);
    }
}
