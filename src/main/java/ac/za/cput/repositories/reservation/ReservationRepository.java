package ac.za.cput.repositories.reservation;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface ReservationRepository  {

    Reservation create(Reservation reservation);
    Reservation read(Reservation reservation);
    Reservation update(Reservation reservation);
    void delete(Reservation bill);
    Set<Reservation> getAll();

}
