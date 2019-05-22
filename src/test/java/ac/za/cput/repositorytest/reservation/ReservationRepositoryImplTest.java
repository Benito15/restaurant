package ac.za.cput.repositorytest.reservation;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.factory.reservationfactory.ReservationFactory;
import ac.za.cput.repositories.reservation.ReservationRepository;
import ac.za.cput.repositories.reservation.impl.ReservationRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationRepositoryImplTest {

    @Autowired
    private ReservationRepository repository;


    @Before
    public void setUp() throws Exception {
        this.repository = ReservationRepositoryImpl.getRepository();

    }

    @Test
    public void getAll() {
        Set<Reservation> getAllReservation = this.repository.getAll();
        System.out.println("Get all Suppliers: " + this.repository.getAll().size());
        Assert.assertNotNull("SupplierRepository: ", repository.getAll());
    }

    @Test
    public void create() {
        Reservation reservation = ReservationFactory.getReservation(5);
        this.repository.create(reservation);
        int size = this.repository.getAll().size();
        System.out.println(size);
        Assert.assertTrue("This repository is not 0", this.repository.getAll().size() >0);

    }

    @Test
    public void update() {
        int updateGuest = 6;
        Reservation reservation = ReservationFactory.getReservation(5);

        repository.create(reservation);
        System.out.println("Reservation 1: \n" + this.repository.getAll());
        System.out.println("----------------------------------------");
        reservation.setTotGuest(updateGuest);

        this.repository.update(reservation);
        System.out.println("After address update---------------------------");
        System.out.println(this.repository.getAll());
        Assert.assertEquals(updateGuest, reservation.getTotGuest());

    }

    @Test
    public void delete() {
        System.out.println(this.repository.getAll().size());
        System.out.println("--------------------------------");
        Reservation reservation = ReservationFactory.getReservation(5);
        Reservation reservation2 = ReservationFactory.getReservation(3);
        this.repository.create(reservation);
        this.repository.create(reservation2);
        System.out.println(this.repository.getAll().size());

        this.repository.delete(reservation2.getTableID());
        System.out.println("After Delete");
        System.out.println(this.repository.getAll().size());
        Assert.assertNotNull(this.repository);

    }

    @Test
    public void read() {
        Reservation reservation = ReservationFactory.getReservation(5);
        Reservation reservation2 = ReservationFactory.getReservation(3);

        this.repository.create(reservation);
        this.repository.create(reservation2);
        System.out.println("Size after creating Objects->");
        System.out.println(this.repository.getAll().size());
        System.out.println("-------------------------------");
        Reservation readReservation = this.repository.read(reservation.getTableID());
        System.out.println("Reading Object into new Object of type Reservation");
        System.out.println(readReservation.getTableID());
        System.out.println("-----------------------------------");

        Assert.assertNotEquals(reservation2.getTableID(), readReservation.getTableID());


    }
}