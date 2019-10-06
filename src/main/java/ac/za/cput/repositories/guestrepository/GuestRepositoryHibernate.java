package ac.za.cput.repositories.guestrepository;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.repositories.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface GuestRepositoryHibernate extends CrudRepository<Guest, String> {




}
