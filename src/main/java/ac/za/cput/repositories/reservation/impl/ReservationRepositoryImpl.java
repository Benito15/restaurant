package ac.za.cput.repositories.reservation.impl;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.repositories.reservation.ReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("ReservationInMemory")
public class ReservationRepositoryImpl implements ReservationRepository {

    private static ReservationRepositoryImpl repository = null;
    private Set<Reservation> reservations;

    private ReservationRepositoryImpl()
    {
        this.reservations = new HashSet<>();
    }

    public static ReservationRepositoryImpl getRepository()
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
        Reservation readReservation= repository.read(reservation);
        if (this.reservations.contains(readReservation)){
            this.reservations.remove(readReservation);
            this.reservations.add(reservation);
            return reservation;

        }
        return null;
    }


    @Override
    public void delete(Reservation reservation) {
        Reservation deleteReservation= read(reservation);
        this.reservations.remove(deleteReservation);
    }

    @Override
    public Reservation read(Reservation reservation) {
        return this.reservations.stream()
                .filter(thisReservation-> thisReservation.getTableID().equalsIgnoreCase(reservation.getTableID())
                        && thisReservation.getGuestID().equalsIgnoreCase(reservation.getGuestID()))
                .findAny().orElse(null);
    }



}
