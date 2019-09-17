package ac.za.cput.repositories.guestrepository;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface GuestRepository extends IRepository<Guest, String>{

//    Guest create(Guest guest);
//    Guest read(Guest guest);
//    Guest update(Guest guest);
//    void delete(Guest guest);
    Set<Guest> getAll();

}
