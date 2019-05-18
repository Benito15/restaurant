package ac.za.cput.repositories.item;

import ac.za.cput.domains.item.Beverage;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface BeverageRepository extends IRepository<Beverage, String> {

    Set<Beverage>getAll();
}
