package ac.za.cput.repositories.reservation;

import ac.za.cput.domains.reservation.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepositoryHibernate extends CrudRepository<Reservation, String> {
}
