package mak.mate.dao;

import mak.mate.model.Person;
import java.util.List;
import java.util.Optional;

public interface PersonDao {
    Person add(Person entity);

    Optional<Person> getById(Long id);

    List<Person>getAll();
}
