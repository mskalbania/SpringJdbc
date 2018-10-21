package edu.spring.jdbc.repository.user;

import edu.spring.jdbc.model.User;

import java.util.List;

public interface UserRepository {

    List<User> all();

    User findOne(Long id);

    void insert(User user);
}
