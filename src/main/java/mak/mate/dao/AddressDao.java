package mak.mate.dao;

import mak.mate.model.Address;
import mak.mate.model.User;

import java.util.List;
import java.util.Optional;

public interface AddressDao {
    Address add(Address entity);

    Optional<Address> getById(Long id);

    List<Address>getAll();
}
