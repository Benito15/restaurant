package ac.za.cput.service.reservation.impl;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.repositories.reservation.ReservationRepositoryHibernate;
import ac.za.cput.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService {

    private static ReservationServiceImpl service = null;
    @Autowired
    private ReservationRepositoryHibernate repository;

    private ReservationServiceImpl()
    {

    }

    public static ReservationServiceImpl  getService()
    {
        if(service == null) return  new ReservationServiceImpl();
        return service;
    }

    @Override
    public Set<Reservation> getAll() {
        return new HashSet<Reservation>((List<Reservation>)repository.findAll());
    }

    @Override
    public Reservation create(Reservation type) {
        return repository.save(type);
    }

    @Override
    public Reservation update(Reservation type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String tableID, String guestID) {
        Reservation deleteReservation= read(tableID, guestID);
        this.repository.delete(deleteReservation);
    }

    @Override
    public Reservation read(String tableID, String guestID) {
        return getAll().stream()
                .filter(thisReservation -> thisReservation.getTableID().equals(tableID)
                        && thisReservation.getGuestID().equals(guestID))
                .findAny().orElse(null);
    }



}
