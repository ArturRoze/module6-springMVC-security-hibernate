package productManagementSystem.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import productManagementSystem.dao.Dao;
import productManagementSystem.model.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class ProductDaoImpl implements Dao<Product> {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);

    }

    @Override
    public List<Product> read() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        return session.createQuery(query).getResultList();
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(product);
    }
}
