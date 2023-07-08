package mak.mate.dao.impl;

import mak.mate.dao.AbstractDao;
import mak.mate.dao.PassportDao;
import mak.mate.model.Passport;
import mak.mate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PassportDaoImpl extends AbstractDao implements PassportDao {
    public PassportDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Passport add(Passport entity) {
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
            throw new RuntimeException("Can't create person " + entity);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return entity;
    }

    @Override
    public Optional<Passport> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Passport passport = session.get(Passport.class, id);
            session.createQuery("from Passport p where p.id = :id", Passport.class).setParameter("id",id);
            return Optional.ofNullable(passport);
        } catch (Exception e) {
            throw new RuntimeException("Can't get passport by id " + id, e);
        }
    }

    @Override
    public List<Passport> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Passport> fromPassport = session.createQuery("from Passport ", Passport.class);
            return fromPassport.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't  get all passports ", e);
        }
    }
}
