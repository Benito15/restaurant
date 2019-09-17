package ac.za.cput.service.guest.impl;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.repositories.guestrepository.GuestRepository;
import ac.za.cput.repositories.guestrepository.impl.GuestRepositoryImpl;
import ac.za.cput.service.guest.GuestService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("GuestService")
public class GuestServiceImpl implements GuestService {

    private static GuestServiceImpl service = null;
    private GuestRepository repository;

    private  GuestServiceImpl()
    {
        repository = GuestRepositoryImpl.getRepository();
    }

    public  GuestServiceImpl getService()
    {
        if(service == null)return  new GuestServiceImpl();
        return  service;
    }

    @Override
    public Set<Guest> getAll() {
        return repository.getAll();
    }

    @Override
    public Guest create(Guest type) {
        return repository.create(type);
    }

    @Override
    public Guest update(Guest type) {
        return this.repository.update(type);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Guest read(String s) {
        return this.repository.read(s);
    }
}
