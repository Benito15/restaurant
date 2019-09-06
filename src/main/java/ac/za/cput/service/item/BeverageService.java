package ac.za.cput.service.item;

import ac.za.cput.domains.purchase.item.Beverage;
import ac.za.cput.service.IService;

import java.util.Set;

public interface BeverageService extends IService<Beverage,String> {
    Set<Beverage> getAll();
}
