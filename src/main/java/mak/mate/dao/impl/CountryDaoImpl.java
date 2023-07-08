package mak.mate.dao.impl;

import mak.mate.dao.AbstractDao;
import mak.mate.dao.CountryDao;
import mak.mate.model.Address;
import mak.mate.model.Country;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class CountryDaoImpl extends AbstractDao implements CountryDao {
    public CountryDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public void add(Country entity) {
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
            throw new RuntimeException("Can't create login " + entity);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Country> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Country country = session.get(Country.class, id);
            return Optional.ofNullable(country);
        } catch (Exception e) {
            throw new RuntimeException("Can't get country by id " + id, e);
        }
    }

    @Override
    public List<Country> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Country> fromAddress = session.createQuery("from Country ", Country.class);
            return fromAddress.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't  get all countryes ", e);
        }
    }
}
