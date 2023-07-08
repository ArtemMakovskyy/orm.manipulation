package mak.mate.dao;

import mak.mate.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    User add(User entity);

    Optional<User> getById(Long id);

    List<User>getAll();
}
