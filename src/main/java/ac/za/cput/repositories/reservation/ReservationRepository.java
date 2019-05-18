package ac.za.cput.repositories.reservation;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface ReservationRepository extends IRepository<Reservation, String> {

    Set<Reservation> getAll();

}
