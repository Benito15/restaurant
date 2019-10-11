package ac.za.cput.repositories.reservation;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.repositories.IRepository;


import java.util.Set;

public interface ReservationRepository  {

    Reservation create(Reservation reservation);
    Reservation read(String tableID ,String guestID);
    Reservation update(Reservation reservation);
    void delete(String tableID, String guestID);
    Set<Reservation> getAll();

}
