package mak.mate.dao.impl;

import mak.mate.dao.AbstractDao;
import mak.mate.dao.PersonDao;
import mak.mate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class PersonDaoImpl extends AbstractDao implements PersonDao {
    public PersonDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Person add(Person entity) {
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
    public Optional<Person> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
//            Person person = session.get(Person.class, id);
//            return Optional.ofNullable(person);
            Query<Person> fromPerson = session.createQuery("" +
                            "from Person p " +
                            "LEFT JOIN FETCH p.address.country " +
                            "where p.id = :id", Person.class)
                    .setParameter("id", id);
            return fromPerson.uniqueResultOptional();
        } catch (Exception e) {
            throw new RuntimeException("Can't get person by id " + id, e);
        }
    }

    @Override
    public List<Person> getAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Person> fromUser = session.createQuery(
                    "from Person p LEFT JOIN FETCH p.address.country"
                    , Person.class);
            return fromUser.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't  get all persons ", e);
        }
    }
}
