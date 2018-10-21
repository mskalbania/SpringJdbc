package edu.spring.jdbc.service.user;

import edu.spring.jdbc.configuration.ApplicationConfiguration;
import edu.spring.jdbc.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    public void shouldCorrectlyReturnAllUsers() {
        User expectedUser = new User(1L, "mat");

        List<User> users = userService.getAll();

        assertThat(users)
                .containsOnly(expectedUser);
    }

    @Test
    public void shouldReturnCorrectUserWhenQueeringById() {
        User expectedUser = new User(1L, "mat");

        User actualUser = userService.get("1");

        assertThat(actualUser)
                .isEqualToComparingFieldByField(expectedUser);
    }

    @Test
    public void shouldCorrectlyAddUser(){
        User given = new User(2L, "test");

        userService.add(given);

        //Should not use production code for testing
        User retrieved = userService.get("2");
        assertThat(retrieved)
                .isEqualToComparingFieldByField(given);
    }
}