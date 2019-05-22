package ac.za.cput.repositories.reservation.impl;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.repositories.reservation.ReservationRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("ReservationInMemory")
public class ReservationRepositoryImpl implements ReservationRepository {

    private static ReservationRepositoryImpl repository = null;
    private Map<String,Reservation> reservations;

    private ReservationRepositoryImpl()
    {
        this.reservations = new HashMap<>();
    }

    public static ReservationRepositoryImpl getRepository()
    {
        if(repository == null) repository = new ReservationRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Reservation> getAll()
    {
        Collection<Reservation> reservations = this.reservations.values();
        Set<Reservation> set = new HashSet<>();
        set.addAll(reservations);
        return set;
    }

    @Override
    public Reservation create(Reservation reservation) {
        this.reservations.put(reservation.getTableID(), reservation);
        return reservation;
    }

    @Override
    public Reservation update(Reservation reservation) {
        this.reservations.replace(reservation.getTableID(), reservation);
        return this.reservations.get(reservation.getTableID());

    }

    @Override
    public void delete(String s) {

        this.reservations.remove(s);
    }

    @Override
    public Reservation read(String s) {
        return this.reservations.get(s);
    }


//    public Reservation findID(String s)
//    {
//        return this.reservations.stream().filter(reservation-> reservation.getTableID().equals(s))
//                .findAny().orElse(null);
//
//
//    }

}
