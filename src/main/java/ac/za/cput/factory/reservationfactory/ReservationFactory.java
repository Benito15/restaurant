package ac.za.cput.factory.reservationfactory;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.util.Misc;

public class ReservationFactory {

    public static Reservation getReservation(String guestID, String tableID, int totGuest)
    {

        return new Reservation(guestID, tableID, totGuest);

    }


}
