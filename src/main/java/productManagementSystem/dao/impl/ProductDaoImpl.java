package productManagementSystem.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import productManagementSystem.dao.Dao;
import productManagementSystem.model.Product;

import java.util.List;

@Repository
public class ProductDaoImpl implements Dao<Product> {

    private static final Logger logger = LoggerFactory.getLogger(ProductDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        logger.info("create product");
    }

    @Override
    public void create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
        logger.info("product: {} created", product );

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Product> read() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Product> productList = session.createQuery("from Product").list();
        for(Product p : productList){
            logger.info("Product List:" +p);
        }
        return productList;
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
        logger.info("product: {} updated", product );
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(product);
        logger.info("product: {} deleted", product);
    }
}
