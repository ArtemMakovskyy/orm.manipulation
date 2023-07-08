package mak.mate.dao;

import mak.mate.model.Country;
import mak.mate.model.Login;

import java.util.List;
import java.util.Optional;

public interface CountryDao {
    void add(Country entity);

    Optional<Country> getById(Long id);

    List<Country>getAll();
}
