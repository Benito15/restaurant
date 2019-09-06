package ac.za.cput.service.item;

import ac.za.cput.domains.purchase.item.Burger;
import ac.za.cput.service.IService;

import java.util.Set;

public interface BurgerService extends IService<Burger,String> {

    Set<Burger> getAll();

}
