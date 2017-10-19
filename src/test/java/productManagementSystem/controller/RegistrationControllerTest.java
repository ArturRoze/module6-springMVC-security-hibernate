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
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;


import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        ControllerConfigurationTest.class,
        MvcConfiguration.class,
        SecurityConfiguration.class})
public class RegistrationControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @Test
    public void registerUser() throws Exception {
    }

}