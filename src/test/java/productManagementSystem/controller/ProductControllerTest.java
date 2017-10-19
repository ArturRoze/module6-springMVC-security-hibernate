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
import productManagementSystem.model.Product;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        MvcConfiguration.class,
        SecurityConfiguration.class,
        ControllerConfigurationTest.class})
public class ProductControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    private Integer id;

    private Product product;

    @Before
    public void setUp() throws Exception {
        product = mock(Product.class);
        id = 1;
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
    @Test
    public void createProduct() throws Exception {
    }

    @Test
    public void readProduct() throws Exception {
    }

    @Test
    public void updateProductForm() throws Exception {
    }

    @Test
    public void updateProduct() throws Exception {
    }

    @Test
    public void deleteProduct() throws Exception {

        mvc.perform(get("/products/delete" + id).with(user("user").roles("ADMIN")))
                .andExpect(redirectedUrl("/products/allProducts"))
                .andExpect(status().isFound());
    }
}