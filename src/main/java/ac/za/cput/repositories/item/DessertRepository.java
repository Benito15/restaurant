package ac.za.cput.repositories.item;

import ac.za.cput.domains.item.Dessert;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface DessertRepository  extends IRepository<Dessert, String> {
    Set<Dessert> getAll();
}
