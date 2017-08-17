package productManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import productManagementSystem.dao.Dao;
import productManagementSystem.model.Product;

import java.util.List;

@Service
public class ProductService {

    private Dao<Product> productDao;

    @Autowired
    public ProductService(Dao<Product> productDao) {
        this.productDao = productDao;
    }

    @Transactional
    public void saveProductToDb(Product product){
        productDao.create(product);
    }

    @Transactional(readOnly = true)
    public List<Product> getAllProducts(){
        return productDao.read();
    }

    @Transactional
    public void updateProduct(Product product){
       productDao.update(product);
    }

    @Transactional
    public void deleteProduct(Product product){
        productDao.delete(product);
    }
}
