package productManagementSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Configuration for Spring security.
 */
@Configuration
@EnableWebSecurity
@ComponentScan("productManagementSystem.controller")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//  @Autowired
//  protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth.inMemoryAuthentication().withUser("user").password("user").roles("USER");
//    auth.inMemoryAuthentication().withUser("artur").password("artur").roles("ADMIN");
//  }

  // We will use BC password encoder and http basic configuration.
  // Configure this all by configure method.
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 1. USER can check all users in the system.
    // 2. ADMIN can create, update or delete users.
//    http.authorizeRequests().antMatchers("/user", "/products/read").hasAnyRole("USER", "ADMIN")
//                            .antMatchers().hasRole("ADMIN")
//            .and()
//            .formLogin()
//            .successForwardUrl("/user/admin")
//            .and()
//            .csrf()
//            .disable();

    http.authorizeRequests()
            .antMatchers("/", "/login", "/registration", "/register").permitAll()
            .antMatchers("/user", "/products/read").hasAnyRole("USER", "ADMIN")
            .antMatchers("/user/**", "/products/**").hasRole("ADMIN")
            .antMatchers("/**").authenticated()
            .anyRequest().denyAll()
            .and()
            .formLogin()
            .defaultSuccessUrl("/products/read")
            .loginPage("/login")
            .failureUrl("/login?error")
            .permitAll()
            .and()
            // разрешаем делать логаут всем
            .logout().permitAll()
            // указываем URL логаута
            .logoutUrl("/logout")
            // указываем URL при удачном логауте
            .logoutSuccessUrl("/login?logout")
            // делаем не валидной текущую сессию
            .invalidateHttpSession(true)
            .and()
            .csrf().disable();
  }
}
