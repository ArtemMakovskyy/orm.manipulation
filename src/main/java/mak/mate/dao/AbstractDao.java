package mak.mate.dao;

import org.hibernate.SessionFactory;

public abstract class AbstractDao {
    protected static SessionFactory sessionFactory;

    public AbstractDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
