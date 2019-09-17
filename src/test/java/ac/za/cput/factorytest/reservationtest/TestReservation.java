package ac.za.cput.factorytest.reservationtest;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.factory.reservationfactory.ReservationFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestReservation {

    @Test
    public void testRes()
    {
        String resID = "45";
        String tableID="1";
        int totGuest = 14;

        Reservation reservation = ReservationFactory.getReservation( resID,tableID,totGuest);
        Assert.assertNotNull(reservation);
    }

}
