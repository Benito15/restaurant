package ac.za.cput.service.reservation;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ReservationService  {
    Reservation create(Reservation reservation);
    Reservation read(String tableID, String guestID );
    Reservation update(Reservation reservation);
    void delete(String tableID, String guestID );
    Set<Reservation>getAll();
}
