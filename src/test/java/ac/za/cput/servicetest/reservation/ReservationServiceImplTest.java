package ac.za.cput.servicetest.reservation;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.factory.reservationfactory.ReservationFactory;
import ac.za.cput.service.reservation.impl.ReservationServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceImplTest {

    @Autowired
    private ReservationServiceImpl service;


    @Test
    public void create() {
        Reservation reservation = ReservationFactory.getReservation(3);
        this.service.create(reservation);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);


    }

    @Test
    public void update() {
        int updateCapacity = 4;
        Reservation reservation = ReservationFactory.getReservation(3);
        this.service.create(reservation);
        Reservation updatedReservation = ReservationFactory.getReservation(updateCapacity);
        this.service.update(updatedReservation);
        Assert.assertTrue(updatedReservation.getTotGuest() > reservation.getTotGuest());


    }

    @Test
    public void delete() {
        Reservation reservation = ReservationFactory.getReservation(3);
        Reservation reservation2 = ReservationFactory.getReservation(6);
        this.service.create(reservation);
        this.service.create(reservation2);
        this.service.delete(reservation2.getTableID());
        Assert.assertTrue(this.service.getAll().size()>=1);


    }

    @Test
    public void read() {
        Reservation reservation = ReservationFactory.getReservation(3);
        Reservation reservation2 = ReservationFactory.getReservation(6);
        this.service.create(reservation);
        this.service.create(reservation2);
        Reservation readRes = this.service.read(reservation.getTableID());
        Assert.assertNotEquals(readRes.getGuestID(), reservation2.getTableID());

    }
}