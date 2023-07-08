package mak.mate.dao.impl;

import mak.mate.dao.AbstractDao;
import mak.mate.dao.AddressDao;
import mak.mate.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class AddressDaoImpl extends AbstractDao implements AddressDao {

    public AddressDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Address add(Address entity) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't create user " + entity);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return entity;
    }

    @Override
    public Optional<Address> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Address address = session.get(Address.class, id);
            return Optional.ofNullable(address);
        } catch (Exception e) {
            throw new RuntimeException("Can't get address by id " + id, e);
        }
    }

    @Override
    public List<Address> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Address> fromAddress = session.createQuery("from Address ", Address.class);
            return fromAddress.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't  get all addresses ", e);
        }
    }
}
