package mak.mate.dao.impl;

import mak.mate.dao.AbstractDao;
import mak.mate.dao.MachineDao;
import mak.mate.model.machine.Machine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class MachineDaoImpl extends AbstractDao implements MachineDao {
    public MachineDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Machine save(Machine entity) {
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
            throw new RuntimeException("Can't create machine " + entity);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return entity;
    }
}
