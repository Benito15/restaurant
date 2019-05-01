package ac.za.cput.repositories.guestrepository;

import ac.za.cput.domains.domainguest.Guest;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface GuestRepository extends IRepository<Guest, String> {

    Set<Guest> getAll();

}
