package mak.mate;

import mak.mate.dao.AddressDao;
import mak.mate.dao.CountryDao;
import mak.mate.dao.LoginDao;
import mak.mate.dao.PassportDao;
import mak.mate.dao.PersonDao;
import mak.mate.dao.impl.AddressDaoImpl;
import mak.mate.dao.impl.CountryDaoImpl;
import mak.mate.dao.impl.LoginDaoImpl;
import mak.mate.dao.impl.PassportDaoImpl;
import mak.mate.dao.impl.PersonDaoImpl;
import mak.mate.model.Address;
import mak.mate.model.Country;
import mak.mate.model.Login;
import mak.mate.model.Passport;
import mak.mate.model.Person;
import mak.mate.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class App {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static AddressDao addressDao = new AddressDaoImpl(sessionFactory);
    private static LoginDao loginDao = new LoginDaoImpl(sessionFactory);
    private static PassportDao passportDao = new PassportDaoImpl(sessionFactory);
    private static PersonDao personDao = new PersonDaoImpl(sessionFactory);
    private static CountryDao countryDao = new CountryDaoImpl(sessionFactory);


    public static void main(String[] args) {
        myPractice();
    }

    private static void myPractice() {
        Person personBobAfterAddPassport = createPersonBobAfterAddPassport();
    }

    private static Person createPersonBobAfterAddPassport() {
        Person bob = new Person("Bob", "Petrov", 25);
        personDao.add(bob);

        Address address = new Address("Kyiv","Shevchenko st.");
        address.setPerson(bob);
        address.setCountry(new Country("Ukraine"));
        addressDao.add(address);

        Passport passport = new Passport();
        passport.setNumber("passport bob 111");
        passport.setPerson(bob);
        passportDao.add(passport);

        Login login = new Login();
        login.setEmail("bob@gmail.com");
        login.setPassword("bob123");
        login.setPerson(bob);
        loginDao.add(login);

        System.out.println( "----------------countryDao >>>>> " +  countryDao.getById(1L));
        System.out.println( "----------------addressDao >>>>> " +  addressDao.getById(1L));

        System.out.println(">>> personDao.getById: >> " + personDao.getById(bob.getId()));
        System.out.println(">>> passportDao.getById: >> " + passportDao.getById(passport.getId()));
        List<Person> personDaoAll = personDao.getAll();
        System.out.println(personDaoAll);
        return bob;
    }


}
