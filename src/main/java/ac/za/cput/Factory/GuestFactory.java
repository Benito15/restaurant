package ac.za.cput.Factory;

import ac.za.cput.Domain.Guest;
import ac.za.cput.Util.Misc;

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
