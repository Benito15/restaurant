package ac.za.cput.service.item;

import ac.za.cput.domains.item.Dessert;
import ac.za.cput.service.IService;

import java.util.Set;

public interface DessertService extends IService<Dessert,String> {
    Set<Dessert> getAll();

}
