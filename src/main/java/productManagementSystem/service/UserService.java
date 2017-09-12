package productManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import productManagementSystem.dao.impl.UserDaoImpl;
import productManagementSystem.model.User;

import java.util.List;

@Service
public class UserService {

    private UserDaoImpl userDao;

    @Autowired
    public UserService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    public User getById(String login) {
        return userDao.getById(login);
    }

    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.read();
    }

    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    @Transactional
    public void update(User user) {
        userDao.update(user);
    }

    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

}
