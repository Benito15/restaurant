package ac.za.cput.GuestTest;

import ac.za.cput.Domain.Guest;
import ac.za.cput.Factory.GuestFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestGuest {

    @Test
    public void guestTest()
    {
       String name = "Benito";
       String lastName = "Kriel";
       int age = 25;

       Guest guest = GuestFactory.getGuest(name,lastName,age);
        System.out.println(guest);
        Assert.assertNotNull(guest.getGuestId());

    }
}
