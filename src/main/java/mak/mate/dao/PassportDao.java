package mak.mate.dao;

import mak.mate.model.Passport;
import mak.mate.model.Person;

import java.util.List;
import java.util.Optional;

public interface PassportDao {
    Passport add(Passport entity);

    Optional<Passport> getById(Long id);

    List<Passport>getAll();
}
