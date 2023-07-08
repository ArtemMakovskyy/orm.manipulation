package mak.mate.dao.impl;

import mak.mate.dao.PersonDao;
import mak.mate.model.Person;

import java.util.List;
import java.util.Optional;

public class PersonDaoImpl implements PersonDao {
    @Override
    public Person add(Person entity) {
        return null;
    }

    @Override
    public Optional<Person> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Person> getAll() {
        return null;
    }
}
