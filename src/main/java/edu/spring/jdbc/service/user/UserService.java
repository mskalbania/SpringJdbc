package edu.spring.jdbc.service.user;

import edu.spring.jdbc.model.User;
import edu.spring.jdbc.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.Long.parseLong;

@Component
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        return repository.all();
    }

    public User get(final String id) {
        return repository.findOne(parseLong(id));
    }

    public void add(final User user) {
        repository.insert(user);
    }
}
