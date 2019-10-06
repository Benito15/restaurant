package ac.za.cput.repositories.guestrepository.impl;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.repositories.guestrepository.GuestRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("GuestInMemory")
public class GuestRepositoryImpl implements GuestRepository {

    private static GuestRepositoryImpl repository = null;
    private Set<Guest> guests;

    public GuestRepositoryImpl() {
        this.guests = new HashSet<>();

    }

    public static GuestRepositoryImpl getRepository() {
        if (repository == null) repository = new GuestRepositoryImpl();
        return repository;

    }

    @Override
    public Guest create(Guest guest) {
        this.guests.add(guest);
        return guest;
    }

    @Override
    public Guest update(Guest guest) {
        Guest readGuest = repository.read(guest.getGuestId());
        if (this.guests.contains(readGuest)) {
            this.guests.remove(readGuest);
            this.guests.add(guest);
            return guest;

        }
        return null;


    }

    ///////
    @Override
    public void delete(String guest) {
        Guest deleteGuest = read(guest);
        this.guests.remove(deleteGuest);

    }


    ////find the student in the set and return it if it exist
    @Override
    public Guest read(String guest) {
        return this.guests.stream()
                .filter(thisGuest -> thisGuest.getGuestId().equalsIgnoreCase(guest))
                .findAny().orElse(null);


    }


    @Override
    public Set<Guest> getAll() {

        return guests;
    }
}
