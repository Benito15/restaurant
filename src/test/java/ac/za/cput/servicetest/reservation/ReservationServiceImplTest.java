//package ac.za.cput.servicetest.reservation;
//
//import ac.za.cput.domains.guest.Guest;
//import ac.za.cput.domains.reservation.Reservation;
//import ac.za.cput.domains.table.Table;
//import ac.za.cput.factory.guestfactory.GuestFactory;
//import ac.za.cput.factory.reservationfactory.ReservationFactory;
//import ac.za.cput.factory.tablefactory.TableFactory;
//import ac.za.cput.service.reservation.impl.ReservationServiceImpl;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ReservationServiceImplTest {
//
//    @Autowired
//    private ReservationServiceImpl service ;
//    Guest guest;
//    Table table;
//    Reservation reservation;
//
//
//    @Before
//    public void setUp() throws Exception {
//        guest = GuestFactory.getGuest("bennn", "Kriel", 25);
//        table = TableFactory.getTable(4, true);
//        reservation = ReservationFactory.getReservation(guest.getGuestId(), table.getTableID(), 3);
//
//    }
//
//    @Test
//    public void create() {
//        Reservation createReservation = this.service.create(reservation);
//
//        Assert.assertNotNull(createReservation);
//
//
//    }
//
//    @Test
//    public void update() {
//        Reservation createReservation = this.service.create(reservation);
//        Reservation readReseravation = this.service.read(createReservation.getTableID(), createReservation.getGuestID());
//        System.out.println(readReseravation);
//
//                Reservation updateReservation = ReservationFactory.getReservation(readReseravation.getGuestID(), readReseravation.getTableID(), 2);
//        this.service.update(updateReservation);
//        Assert.assertNotNull(updateReservation.getTableID());
//    }
//    @Test
//    public void delete() {
//        Reservation createReservation = this.service.create(reservation);
//        this.service.delete(createReservation.getTableID(), createReservation.getGuestID());
//
//
//    }
//
//    @Test
//    public void read() {
//        Reservation createReservation = this.service.create(reservation);
//        Reservation readReseravation = this.service.read(createReservation.getTableID(), createReservation.getGuestID());
//        Assert.assertNotNull(readReseravation.getTableID(), readReseravation.getGuestID());
//
//    }
//}