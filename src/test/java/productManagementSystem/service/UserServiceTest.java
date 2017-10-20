package productManagementSystem.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import productManagementSystem.dao.Dao;
import productManagementSystem.dao.impl.UserDaoImpl;
import productManagementSystem.model.User;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class UserServiceTest {

    private User user;
    private UserDaoImpl userDao;
    private UserService userService;
    private String rightId;
    private String wrongId;

    @Before
    public void setUp() throws Exception {
        PasswordEncoder passwordEncoder = mock(PasswordEncoder.class);
        user = mock(User.class);
        userDao = mock(UserDaoImpl.class);
        userService = new UserService(userDao);
        rightId = "login";
        wrongId = "login999";
    }

    @Test
    public void userNotExists() {
        when(userDao.getById(wrongId)).thenReturn(null);
        assertNull(userService.getById(wrongId));
    }

    @Test
    public void getById() throws Exception {
        when(userDao.getById(rightId)).thenReturn(user);
        assertEquals(user, userService.getById(rightId));
    }

    @Test
    public void getAll() throws Exception {
        when(userDao.read()).thenReturn(Collections.singletonList(user));
        assertEquals(Collections.singletonList(user), userService.getAll());
    }

    @Test
    public void getAllEmpty() throws Exception {
        when(userDao.read()).thenReturn(Collections.emptyList());
        assertEquals(Collections.emptyList(), userService.getAll());
    }

    @Test
    public void create() throws Exception {
        doAnswer(i -> null).when(userDao).create(user);
        userDao.create(user);
        verify(userDao, times(1)).create(user);
    }

    @Test
    public void update() throws Exception {
        doAnswer(i -> null).when(userDao).update(user);
        userDao.update(user);
        verify(userDao, times(1)).update(user);
    }

    @Test
    public void delete() throws Exception {
        doAnswer(i -> null).when(userDao).delete(user);
        userDao.delete(user);
        verify(userDao, times(1)).delete(user);
    }
}