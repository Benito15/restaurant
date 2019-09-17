package ac.za.cput.service.reservation.impl;

import ac.za.cput.domains.reservation.Reservation;
import ac.za.cput.repositories.reservation.ReservationRepository;
import ac.za.cput.repositories.reservation.impl.ReservationRepositoryImpl;
import ac.za.cput.service.reservation.ReservationService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ReservationService")
public class ReservationServiceImpl implements ReservationService {

    private static ReservationServiceImpl service = null;
    private ReservationRepository repository;

    private ReservationServiceImpl()
    {
        repository = ReservationRepositoryImpl.getRepository();
    }

    public ReservationServiceImpl  getService()
    {
        if(service == null) return  new ReservationServiceImpl();
        return service;
    }

    @Override
    public Set<Reservation> getAll() {
        return repository.getAll();
    }

    @Override
    public Reservation create(Reservation type) {
        return repository.create(type);
    }

    @Override
    public Reservation update(Reservation type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(Reservation reservation) {
        this.repository.delete(reservation);

    }

    @Override
    public Reservation read(Reservation reservation) {
        return this.repository.read(reservation);
    }
}
