package productManagementSystem.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import productManagementSystem.config.MvcConfiguration;
import productManagementSystem.config.SecurityConfiguration;
import productManagementSystem.controller.configuration.ControllerConfigurationTest;
import productManagementSystem.model.User;
import productManagementSystem.service.UserService;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.anonymous;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        ControllerConfigurationTest.class,
        MvcConfiguration.class,
        SecurityConfiguration.class})
public class UserControllerTest {

    private MockMvc mvc;

    @Autowired
    private UserService userService;

    @Autowired
    private WebApplicationContext context;

    private User user;

    @Before
    public void setUp() throws Exception {

        user = mock(User.class);

        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    public void loginPage() throws Exception {
        mvc.perform(get("/", "login").with(anonymous()))
                .andExpect(view().name("login"))
                .andExpect(status().isOk());
    }

    @Test
    public void authenticatedLoginTest() throws Exception {
        mvc.perform(get("/", "/login").with(user("user").roles("ADMIN", "USER")))
                .andExpect(view().name("login"))
                .andExpect(status().isOk());
    }

    @Test
    public void logout() throws Exception {
        mvc.perform(post("/logout").with(user("user").roles("ADMIN", "USER")))
                .andExpect(redirectedUrl("/login?logout"))
                .andExpect(status().isFound());
    }
}