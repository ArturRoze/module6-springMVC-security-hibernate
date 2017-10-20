package productManagementSystem.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import productManagementSystem.dao.Dao;
import productManagementSystem.dao.impl.ProductDaoImpl;
import productManagementSystem.model.Product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @BeforeClass
    public static void beforeClass() {
        MockitoAnnotations.initMocks(ProductService.class);
    }

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductDaoImpl productDao;

    @Test
    public void getById() throws Exception {
        // arrange
        Product expectedProduct = configureProductDao();
        when(productService.getById(expectedProduct.getId())).thenReturn(expectedProduct);

        // action
        Product actualProduct = productService.getById(1);

        //assert
        assertNotNull("get by id from ProductService returned not Null object", actualProduct);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void saveProductToDb() throws Exception {
        // arrange
        Product product = configureProductDao();
        doAnswer(invocation -> null).when(productDao).create(product);

        // action
        productService.saveProductToDb(product);

        //assert
        verify(productDao, times(1)).create(product);
    }

    @Test
    public void getAllProducts() throws Exception {
        // arrange
        Product product = configureProductDao();
        when(productService.getAllProducts()).thenReturn(Arrays.asList(product, product));

        // action
        productService.getAllProducts();

        //assert
        verify(productDao, times(1)).read();
    }

    @Test
    public void updateProduct() throws Exception {
        // arrange
        Product product = configureProductDao();
        doAnswer(invocation -> null).when(productDao).update(product);

        // action
        productService.updateProduct(product);

        //assert
        verify(productDao, times(1)).update(product);
    }

    @Test
    public void deleteProduct() throws Exception {
        // arrange
        Product product = configureProductDao();
        when(productService.getAllProducts()).thenReturn(Arrays.asList(product, product));
        doAnswer(i -> null).when(productDao).delete(product);

        // action
        productService.deleteProduct(product);

        //assert
        verify(productDao, times(1)).delete(product);
    }
    @Test
    public void deleteEmptyProductsListTest() throws Exception {

        //arrange
        Product product = configureProductDao();
        when(productService.getAllProducts()).thenReturn(Collections.emptyList());

        //action
        productService.deleteProduct(product);

        //assert
        verify(productDao, times(1)).delete(product);
    }

    private Product configureProductDao() {

        Product product = new Product();

        BigDecimal cost = new BigDecimal("1115.37");
        product.setId(1);
        product.setName("TV");
        product.setCost(cost);
        product.setDescription("yellow");
        product.setVendor("Samsung");

        return product;
    }
}