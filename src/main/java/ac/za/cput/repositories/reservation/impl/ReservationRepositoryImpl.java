package ac.za.cput.repositories.reservation.impl;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.repositories.reservation.ReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("ReservationInMemory")
public class ReservationRepositoryImpl implements ReservationRepository {

    private Set<Reservation> reservations;
    private static ReservationRepository repository = null;

    public ReservationRepositoryImpl()
    {
        this.reservations = new HashSet<>();
    }

    public static ReservationRepository getRepository()
    {
        if(repository == null) repository = new ReservationRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Reservation> getAll()
    {
        return reservations;
    }

    @Override
    public Reservation create(Reservation reservation) {
        this.reservations.add(reservation);
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        Reservation readReservation= repository.read(reservation.getTableID(), reservation.getGuestID());
        if (this.reservations.contains(readReservation)){
            this.reservations.remove(readReservation);
            this.reservations.add(reservation);
            return reservation;

        }
        return null;
    }


    @Override
    public void delete(String tableID, String guestID) {
        Reservation deleteReservation= read(tableID, guestID);
        this.reservations.remove(deleteReservation);
    }

    @Override
    public Reservation read(String tableID, String guestID) {
        return this.reservations.stream()
                .filter(thisReservation -> thisReservation.getTableID().equals(tableID)
                        && thisReservation.getGuestID().equals(guestID))
                .findAny().orElse(null);
    }



}
