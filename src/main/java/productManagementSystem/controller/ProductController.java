package productManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import productManagementSystem.model.Product;
import productManagementSystem.service.ProductService;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/products/action")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseBody // because created:+product.jsp does not exist
    @RequestMapping("/create")
    public String createProduct() {
        Product product = new Product("TV", new BigDecimal("777"), "device", "LG");
        productService.saveProductToDb(product);
        return "created: " + product;
    }

    @RequestMapping("/read")
    public String readProduct(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("listProducts", allProducts);
        return "allProducts";
    }

    @ResponseBody
    @RequestMapping("/update/{productId}")
    public String updateProduct(@PathVariable String productId) {
        Product productToUpdate = new Product("aa", BigDecimal.ONE,
                "ss", "dd");

        if(!productService.getAllProducts().isEmpty()) {
            Product productFromDatabase = productService.getAllProducts()
                    .get(Integer.parseInt(productId));

            productFromDatabase.setCost(productToUpdate.getCost());
            productFromDatabase.setName(productToUpdate.getName());
            productFromDatabase.setVendor(productToUpdate.getVendor());
            productFromDatabase.setDescription(productToUpdate.getDescription());

            productFromDatabase.setCost(productToUpdate.getCost());

            productService.updateProduct(productFromDatabase);

            return "updated: " + productFromDatabase;
        }

        return "object not found";

    }

    @ResponseBody
    @RequestMapping("/delete/{productId}")
    public String deleteProduct(String productId) {
        Product productFromDatabase = productService.getAllProducts()
                .get(Integer.parseInt(productId));

        productService.deleteProduct(productFromDatabase);

        return "deleted: " + productFromDatabase;
    }
}
