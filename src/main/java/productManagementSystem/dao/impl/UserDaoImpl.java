package productManagementSystem.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import productManagementSystem.dao.Dao;
import productManagementSystem.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements Dao<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        logger.info("create user");
    }

    public User getById(String id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public User getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public void create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        logger.info("user: {} created", user );

    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> read() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();
        for(User u : userList){
            logger.info("User List:" + u);
        }
        return userList;
    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("user: {} updated", user );
    }

    @Override
    public void delete(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(user);
        logger.info("user: {} deleted", user
        );
    }
}
