package ac.za.cput.repositories.item;

import ac.za.cput.domains.item.Burger;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface BurgerRepository extends IRepository<Burger, String> {
    Set<Burger> getAll();
}
