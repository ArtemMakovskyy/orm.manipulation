package mak.mate.dao;

import mak.mate.model.Login;
import mak.mate.model.Passport;

import java.util.List;
import java.util.Optional;

public interface LoginDao {
    Login add(Login entity);

    Optional<Login> getById(Long id);

    List<Login>getAll();
}
