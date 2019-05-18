package ac.za.cput.factory.reservationfactory;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.util.Misc;

public class ReservationFactory {

    public static Reservation getReservation(int totGuest)
    {
        return new Reservation.Builder().totGuest(totGuest)
                .guestID(Misc.generateId())
                .tableID(Misc.generateId())
                .build();

    }


}
