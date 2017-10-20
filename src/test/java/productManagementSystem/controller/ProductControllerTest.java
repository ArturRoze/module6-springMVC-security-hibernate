package productManagementSystem.controller;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import productManagementSystem.service.ProductService;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Autowired
    private ProductService productService;

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
        when(productService.getById(id)).thenReturn(product);

        mvc.perform(post("/products/create/").with(user("user").roles("ADMIN"))
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("name", "aa")
                .param("vendor", "11")
                .param("dollars", "1")
                .param("cents", "11")
                .param("description", "desc"))

                .andExpect(redirectedUrl("/products/allProducts"))
                .andExpect(status().isFound());
    }

    @Test
    public void readProduct() throws Exception {
        when(productService.getAllProducts()).thenReturn(Collections.singletonList(product));

        mvc.perform(get("/products/allProducts").with(user("user").roles("USER", "ADMIN")))
                .andExpect(model().attribute("listProducts", equalTo(productService.getAllProducts())))
                .andExpect(view().name("allProducts"))
                .andExpect(status().isOk());
    }

    @Test
    public void updateProductForm() throws Exception {
        when(productService.getById(id)).thenReturn(product);

        mvc.perform(get("/products/product_update/" + id).with(user("user").roles("ADMIN")))
                .andExpect(model().attribute("product", equalTo(productService.getById(id))))
                .andExpect(view().name("product_update"))
                .andExpect(status().isOk());
    }

    @Test
    @Ignore
    public void updateProduct() throws Exception {
        when(productService.getById(id)).thenReturn(product);

        mvc.perform(post("/products/update").with(user("user").roles("ADMIN"))
                .param("id", "1")
                .param("name", "name")
                .param("vendor", "vendor")
                .param("dollars", "11")
                .param("cents", "11")
                .param("description", "description"))

                .andExpect(redirectedUrl("/products/allProducts"))
                .andExpect(status().isFound());
    }

    @Test
    public void deleteProduct() throws Exception {

        mvc.perform(get("/products/delete/" + id).with(user("user").roles("ADMIN")))
                .andExpect(redirectedUrl("/products/allProducts"))
                .andExpect(status().isFound());
    }
}