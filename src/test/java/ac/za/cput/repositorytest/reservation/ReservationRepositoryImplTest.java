//package ac.za.cput.repositorytest.reservation;
//
//import ac.za.cput.domains.guest.Guest;
//import ac.za.cput.domains.reservation.Reservation;
//import ac.za.cput.domains.table.Table;
//import ac.za.cput.factory.guestfactory.GuestFactory;
//import ac.za.cput.factory.reservationfactory.ReservationFactory;
//import ac.za.cput.factory.tablefactory.TableFactory;
//import ac.za.cput.repositories.reservation.ReservationRepository;
//import ac.za.cput.repositories.reservation.impl.ReservationRepositoryImpl;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.Set;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ReservationRepositoryImplTest {
//
//   @Autowired
//    private ReservationRepository repository;
//    private Table table;
//    private Guest guest;
//    private Reservation reservation;
//    private Reservation reservation2;
//
//    @Before
//    public void setUp() throws Exception {
//        this.guest = GuestFactory.getGuest("Bennie", "Kriel", 25);
//        this.table = TableFactory.getTable(25, true);
//        this.reservation= ReservationFactory.getReservation(guest.getGuestId(),table.getTableID(),table.getCapacity());
//        this.reservation2 = ReservationFactory.getReservation(guest.getGuestId(), table.getTableID(), table.getCapacity());
//        this.repository = ReservationRepositoryImpl.getRepository();
//    }
//
//    @Test
//    public void getAll() {
//        Set<Reservation> getAllReservation = this.repository.getAll();
//        System.out.println("Get all Suppliers: " + this.repository.getAll().size());
//        Assert.assertNotNull("SupplierRepository: ", repository.getAll());
//    }
//
//    @Test
//    public void create() {
//
//        this.repository.create(reservation);
//        int size = this.repository.getAll().size();
//        System.out.println(size);
//        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);
//
//    }
//
//    @Test
//    public void update() {
//        int updateGuest = 6;
//
//        repository.create(reservation);
//        System.out.println("Reservation 1: \n" + this.repository.getAll());
//        System.out.println("----------------------------------------");
//        reservation.setTotGuest(updateGuest);
//
//        this.repository.update(reservation);
//        System.out.println("After address update---------------------------");
//        System.out.println(this.repository.getAll());
//        Assert.assertEquals(updateGuest, reservation.getTotGuest());
//
//    }
//
//    @Test
//    public void delete() {
//        System.out.println(this.repository.getAll().size());
//        System.out.println("--------------------------------");
//        Reservation reservation2 = ReservationFactory.getReservation("scss","scs",34);
//        this.repository.create(reservation);
//        this.repository.create(reservation2);
//        System.out.println(this.repository.getAll().size());
//
//        this.repository.delete(reservation2.getTableID(), reservation2.getGuestID());
//        System.out.println("After Delete");
//        System.out.println(this.repository.getAll().size());
//        Assert.assertNotNull(this.repository);
//
//    }
//
//    @Test
//    public void read() {
//
//       Reservation createReservation = this.repository.create(reservation);
//        this.repository.create(createReservation);
//
//
//        Reservation readReservation = this.repository.read(createReservation.getTableID(), createReservation.getGuestID());
//       Assert.assertNotNull(readReservation);
//
//
//    }
//}