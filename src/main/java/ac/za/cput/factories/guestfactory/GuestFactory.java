package ac.za.cput.factories.guestfactory;

import ac.za.cput.domains.domainguest.Guest;
import ac.za.cput.util.Misc;

public class GuestFactory {

    public static Guest getGuest(String name,String lastname, int age)
    {
        return new Guest.Builder().age(age)
                .guestName(name)
                .guestSurname(lastname)
                .guestId(Misc.generateId())
                .build();


    }


}
