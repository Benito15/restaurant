package ac.za.cput.service.reservation;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ReservationService  extends IService<Reservation,String> {
    Set<Reservation>getAll();
}
