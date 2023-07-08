package mak.mate.dao.impl;

import mak.mate.dao.AbstractDao;
import mak.mate.dao.LoginDao;
import mak.mate.model.Login;
import mak.mate.model.Passport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class LoginDaoImpl  extends AbstractDao implements LoginDao {
    public LoginDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Login add(Login entity) {
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
        return entity;
    }
    @Override
    public Optional<Login> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Login login = session.get(Login.class, id);
            session.createQuery("from Passport p where p.id = :id", Login.class).setParameter("id",id);
            return Optional.ofNullable(login);
        } catch (Exception e) {
            throw new RuntimeException("Can't get login by id " + id, e);
        }
    }
    @Override
    public List<Login> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Login> fromLogin = session.createQuery("from Login ", Login.class);
            return fromLogin.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't  get all logins ", e);
        }
    }
}
