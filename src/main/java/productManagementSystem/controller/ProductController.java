package productManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import productManagementSystem.model.Product;
import productManagementSystem.model.Vendor;
import productManagementSystem.service.ProductService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/action/{someAction}")
    public String pathOne(@PathVariable("someAction") String someAction) {

        Product product = new Product("TV", new BigDecimal("777"), "device", Vendor.LG);

        if (someAction.equals("create")) {
            productService.saveProductToDb(product);

        } else if (someAction.equals("read")) {
            productService.getAllProducts();

        } else if (someAction.equals("update")) {
            productService.updateProduct(product);

        } else if (someAction.equals("delete")) {
            productService.deleteProduct(product);

        } else {
            return "unknown action";
        }
        return "test";
    }
}
