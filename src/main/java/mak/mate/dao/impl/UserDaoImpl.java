package mak.mate.dao.impl;

import mak.mate.dao.AbstractDao;
import mak.mate.dao.UserDao;
import mak.mate.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao implements UserDao {
    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public User add(User entity) {
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
    public Optional<User> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
            return Optional.ofNullable(user);
        } catch (Exception e) {
            throw new RuntimeException("Can't get user by id " + id, e);
        }
    }

    @Override
    public List<User> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<User> fromUser = session.createQuery("from User ", User.class);
            return fromUser.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't  get all users ", e);
        }
    }
}
