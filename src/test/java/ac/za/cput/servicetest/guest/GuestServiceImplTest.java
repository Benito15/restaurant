package ac.za.cput.servicetest.guest;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.service.guest.impl.GuestServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GuestServiceImplTest {

    @Autowired
    private GuestServiceImpl service ;

    @Test
    public void getAll() throws  Exception{
        Guest guest = GuestFactory.getGuest("Benito","Kriel", 20);
        System.out.println("++++++");
        service.create(guest);
        System.out.println(service.getAll());

    }



    @Test
    public void create() {
        Guest guest = GuestFactory.getGuest("Benito","Kriel", 20);
        service.create(guest);
        System.out.println(service.getAll());
        Assert.assertTrue(this.service.getAll().size()>0);

    }

    @Test
    public void update() {
       String changeName = "Martin";
        Guest guest = GuestFactory.getGuest("Benito","Kriel", 20);
        service.create(guest);
        Guest updateGuest = GuestFactory.getGuest(changeName, guest.getGuestSurname(), guest.getAge());
        this.service.update(updateGuest);
        Assert.assertTrue(updateGuest.getGuestName().contains(changeName));

    }

    @Test
    public void delete() {
        Guest guest = GuestFactory.getGuest("Benito","Kriel", 20);
        Guest guest2 = GuestFactory.getGuest("Lorenzo","Kriel", 15);
        service.create(guest);
        service.create(guest2);
        this.service.delete(guest2.getGuestId());
        Assert.assertTrue(this.service.getAll().size()>=1);

    }

    @Test
    public void read() {
        Guest guest = GuestFactory.getGuest("Benito","Kriel", 20);
        Guest guest2 = GuestFactory.getGuest("Lorenzo","Kriel", 15);
        service.create(guest);
        service.create(guest2);
        Guest readGuest = this.service.read(guest.getGuestId());
        Assert.assertNotEquals(readGuest.getGuestName(), guest2.getGuestName());
    }
}