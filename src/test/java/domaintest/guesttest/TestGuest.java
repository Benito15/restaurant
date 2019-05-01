package domaintest.guesttest;

import ac.za.cput.domains.domainguest.Guest;
import ac.za.cput.factory.guestfactory.GuestFactory;
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
