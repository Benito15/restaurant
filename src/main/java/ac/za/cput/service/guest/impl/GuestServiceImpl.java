package ac.za.cput.service.guest.impl;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.repositories.guestrepository.GuestRepository;
import ac.za.cput.repositories.guestrepository.GuestRepositoryHibernate;
import ac.za.cput.repositories.guestrepository.impl.GuestRepositoryImpl;
import ac.za.cput.service.guest.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("GuestService")
public class GuestServiceImpl implements GuestService {

    private static GuestServiceImpl service = null;
    @Autowired
    private GuestRepositoryHibernate repository;

    private  GuestServiceImpl()
    {

    }

    public  GuestServiceImpl getService()
    {
        if(service == null)return  new GuestServiceImpl();
        return  service;
    }

    @Override
    public Set<Guest> getAll() {

        return new HashSet<Guest>((List<Guest>)repository.findAll());
    }

    @Override
    public Guest create(Guest type) {
        return repository.save(type);
    }

    @Override
    public Guest update(Guest type) {
        return this.repository.save(type);
    }

    @Override
    public void delete(String s) {
        this.repository.deleteById(s);
    }

    @Override
    public Guest read(String s) {
        return this.repository.findById(s).orElse(null);
    }
}
