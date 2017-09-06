package productManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import productManagementSystem.model.Product;
import productManagementSystem.service.ProductService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createProduct(@RequestParam("name") String name,
                                @RequestParam("vendor") String vendor,
                                @RequestParam("dollars") Integer dollars,
                                @RequestParam("cents") Integer cents,
                                @RequestParam("description") String description
    ) throws IOException {
        Product product = new Product();
        product.setName(name);
        product.setVendor(vendor);
        product.setDescription(description);
        BigDecimal price = BigDecimal.valueOf(dollars + (double) cents / 100);
        product.setCost(price);
        productService.saveProductToDb(product);
        return "redirect:/products/allProducts";
    }

    @RequestMapping({"/read", "/allProducts"})
    public String readProduct(Model model) {
        List<Product> allProducts = productService.getAllProducts();
        model.addAttribute("listProducts", allProducts);
        return "allProducts";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product_update/{id}")
    public String updateProduct(@PathVariable("id") String id, Model model) {
        Product product = productService.getById(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "product_update";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String updateProduct(@RequestParam("id") int id,
                                @RequestParam("name") String name,
                                @RequestParam("vendor") String vendor,
                                @RequestParam("dollars") Integer dollars,
                                @RequestParam("cents") Integer cents,
                                @RequestParam("description") String description
    ) throws IOException {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setVendor(vendor);
        product.setDescription(description);
        BigDecimal price = BigDecimal.valueOf(dollars + (double) cents / 100);
        product.setCost(price);
        productService.updateProduct(product);
        return "redirect:/products/allProducts";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/delete/{id}")
    public String deleteProduct(@PathVariable("id") String id) {
        Product product = productService.getById(Integer.parseInt(id));
        productService.deleteProduct(product);
        return "redirect:/products/allProducts";
    }

}
