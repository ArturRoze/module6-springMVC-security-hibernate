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

  @Autowired
  protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("Vasya").password("vasya").roles("USER");
    auth.inMemoryAuthentication().withUser("Artur").password("artur").roles("ADMIN");
  }

  // We will use BC password encoder and http basic configuration.
  // Configure this all by configure method.
  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // 1. USER can check all users in the system.
    // 2. ADMIN can create, update or remove users.
    http.authorizeRequests().antMatchers("/user/list").hasAnyRole("USER", "ADMIN")
                            .antMatchers("/user/**").hasRole("ADMIN")
                            .and().formLogin();
  }
}
