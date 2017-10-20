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
import productManagementSystem.dao.impl.UserDaoImpl;
import productManagementSystem.model.Product;

import static org.junit.Assert.*;
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
    private Dao dao;

    @Mock
    private ProductDaoImpl productDao;

    @Mock
    private UserDaoImpl userDao;

    private Product configureProductDao() {

        Product product = new Product();
        product.setId(1);
        product.setName("TV");
        product.setDescription("yellow");
        product.setVendor("Samsung");

        return product;
    }

    @Test
    public void getById() throws Exception {
        // arrange
        Product expectedProduct = configureProductDao();
        when(productDao.getById(expectedProduct.getId())).thenReturn(expectedProduct);

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
    }

    @Test
    public void updateProduct() throws Exception {
    }

    @Test
    public void deleteProduct() throws Exception {
    }

}