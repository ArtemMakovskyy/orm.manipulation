package mak.mate;

import mak.mate.dao.MachineDao;
import mak.mate.dao.impl.MachineDaoImpl;
import mak.mate.model.machine.ElectricCar;
import mak.mate.model.machine.Machine;
import mak.mate.model.machine.RacingCar;
import mak.mate.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;

public class AppMachine {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    private static MachineDao machineDao = new MachineDaoImpl(sessionFactory);

    public static void main(String[] args) {

        //save machine
//        Machine volvoTrack = new Machine();
//        volvoTrack.setName("Volvo Track");
//        volvoTrack.setPrice(BigDecimal.valueOf(55999));
//        machineDao.save(volvoTrack);

        ElectricCar tesla = new ElectricCar("Tesla", BigDecimal.valueOf(31999), 0.98);
        RacingCar ferrari = new RacingCar("Ferrari",BigDecimal.valueOf(87999),500);
        machineDao.save(tesla);
        machineDao.save(ferrari);
    }
}
