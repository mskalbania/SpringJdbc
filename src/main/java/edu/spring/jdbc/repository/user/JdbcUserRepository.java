package edu.spring.jdbc.repository.user;

import edu.spring.jdbc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcUserRepository implements UserRepository {

    private static final String SELECT_ALL = "SELECT * FROM users";
    private static final String SELECT_ONE = "SELECT * FROM users WHERE id = ?";
    private static final String INSERT = "INSERT INTO users (id, name) values (?, ?)";

    private JdbcOperations userOperations;

    @Autowired
    public JdbcUserRepository(final JdbcOperations userOperations) {
        this.userOperations = userOperations;
    }

    @Override
    public List<User> all() {
        return userOperations.query(SELECT_ALL, this::mapToUser);
    }

    @Override
    public User findOne(final Long id) {
        return userOperations.queryForObject(SELECT_ONE, this::mapToUser, id);
    }

    @Override
    public void insert(final User user) {
        userOperations.update(INSERT,
                user.getId(),
                user.getName());
    }

    private User mapToUser(ResultSet resultSet, int rowNumber) throws SQLException {
        return new User(resultSet.getLong("id"), resultSet.getString("name"));
    }
}
