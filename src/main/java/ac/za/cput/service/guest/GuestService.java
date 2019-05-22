package ac.za.cput.service.guest;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.service.IService;

import java.util.Set;

public interface GuestService extends IService<Guest, String> {
    Set<Guest> getAll();
}
