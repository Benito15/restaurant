package reservationtest;

import ac.za.cput.domains.domainreservation.Reservation;
import ac.za.cput.factories.reservationfactory.ReservationFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestReservation {

    @Test
    public void testRes()
    {
        String resID = "45";
        int totGuest = 14;

        Reservation reservation = ReservationFactory.getReservation(resID, totGuest);
        Assert.assertNotNull(reservation);
    }

}
