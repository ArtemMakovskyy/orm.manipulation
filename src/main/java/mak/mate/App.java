package mak.mate;

import mak.mate.dao.AddressDao;
import mak.mate.dao.UserDao;
import mak.mate.dao.impl.AddressDaoImpl;
import mak.mate.dao.impl.UserDaoImpl;
import mak.mate.model.Address;
import mak.mate.model.User;
import mak.mate.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class App {
   private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static UserDao userDao = new UserDaoImpl(sessionFactory);
    private static AddressDao addressDao = new AddressDaoImpl(sessionFactory);

    public static void main(String[] args) {
        firstTemplate();
        myPractice();
    }

    private static void myPractice() {

    }

    private static void firstTemplate() {
        User bob = new User("Bob");
        bob.setAddress(new Address("Kyiv", "Shevchenka st.", bob));
        userDao.add(bob);
        User userBobFromDb = userDao.getById(1L).get();
        System.out.println(userBobFromDb);
    }
}
