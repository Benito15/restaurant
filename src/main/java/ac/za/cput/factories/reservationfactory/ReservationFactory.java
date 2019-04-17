package ac.za.cput.factories.reservationfactory;

import ac.za.cput.domains.domainreservation.Reservation;
import ac.za.cput.util.Misc;

public class ReservationFactory {

    public static Reservation getReservation(String reservationID, int totGuest)
    {
        return new Reservation.Builder().totGuest(totGuest)
                .resID(Misc.generateId()).build();

    }


}
