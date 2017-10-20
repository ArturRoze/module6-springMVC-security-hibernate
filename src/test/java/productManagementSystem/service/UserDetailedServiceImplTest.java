package productManagementSystem.service;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import productManagementSystem.model.User;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailedServiceImplTest {

    @BeforeClass
    public static void beforeClass() {
        MockitoAnnotations.initMocks(UserDetailedServiceImpl.class);
    }

    @InjectMocks
    private UserDetailedServiceImpl userDetailsService;

    @Mock
    private UserService userService;

    private UserDetails details;

    @Test
    public void loadUserByUsernameUserIsNullUserIsNotNull() throws Exception {

        User user = mock(User.class);

        when(userService.getById(anyString())).thenReturn(null);
        when(userService.getById(anyString())).thenReturn(user);

        details = userDetailsService.loadUserByUsername(anyString());

        assertNotNull(details);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsernameUserIsNull() throws Exception {

        when(userService.getById(anyString())).thenReturn(null);

        userDetailsService.loadUserByUsername(null);
    }
}