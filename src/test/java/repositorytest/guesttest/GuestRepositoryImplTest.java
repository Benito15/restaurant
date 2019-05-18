package repositorytest.guesttest;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.factory.guestfactory.GuestFactory;
import ac.za.cput.repositories.guestrepository.GuestRepository;
import ac.za.cput.repositories.guestrepository.impl.GuestRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class GuestRepositoryImplTest {

    private GuestRepository repository;

    @Before
    public void setUp() throws Exception {

        this.repository = GuestRepositoryImpl.getRepository();

    }


    @Test
    public void create() {
//    Guest createGuest = this.repository.create(this.guest);
//        System.out.println("Create-Guest= " + createGuest);
//        getAll();
       //    Assert.assertSame(createGuest,this.guest);

        // create a Guest
        Guest guest= GuestFactory.getGuest("Benito","ZOLA",25);
        Guest newGuest= GuestFactory.getGuest("Benito","ZOLA",25);
        //Move guest to guest Repository
        repository.create(guest);

        //Test guest Repository if it is Null
        Assert.assertNotNull(repository.getAll());
    }


@Test
public void update() {
//    String newGuest = "NEW GUEST LORENZO";
//    Guest guest = new Guest.Builder().guestName(newGuest).build();
//    System.out.println("In update, about_to_update = " + guest);
//    Guest updatedGuest = this.repository.update(guest);
//    System.out.println("In update, about_to_update = " + updatedGuest);
   // Assert.assertSame(newGuest, updatedGuest.getGuestName());
    //Create guest
    Guest guest= GuestFactory.getGuest("Benito","ZOLA",25);
    //Move guest to guest repo
    repository.create(guest);

    Guest newGuest = GuestFactory.getGuest("Lorenzo","ZOLA",25);
    //newGuest.getGuestId();
    repository.update(newGuest);
    Assert.assertNotSame(guest, newGuest);
    System.out.println(guest.getGuestName()+"\n" + newGuest.getGuestName());


}

    @Test
    public void delete() {
//        Guest savedGuest =  getsavedGuest();
//        this.repository.delete(savedGuest.getGuestId());
      //   Assert.assertNull(delsavedGuest);
//        Guest guest = GuestFactory.getGuest("Benito", "Kriel",20);
//        Guest guest1 = GuestFactory.getGuest("Lorenzo", "Kriel",12);
//
//        Assert.assertNull(repository.getAll());
        Guest guest = GuestFactory.getGuest("Benitoooo", "Kriel",30);
        Guest newGuest = GuestFactory.getGuest("Benito", "Kriel",30);
        repository.create(guest);
        repository.create(newGuest);

        repository.delete(newGuest.getGuestId());
        System.out.println(repository.getAll());

        Assert.assertEquals(newGuest,newGuest);



    }

    @Test
    public void read() {

//        System.out.println("In read, guestID = "+ guest.getGuestId());
//        Guest read = this.repository.read(guest.getGuestId());
//        System.out.println("IN read, read= " + read);
//        getAll();
        Guest guest = GuestFactory.getGuest("Benito", "Kriel",30);
        Guest newguest = GuestFactory.getGuest("Benzema", "Messi",25);

        repository.create(guest);
        repository.create(newguest);

        Guest readGuest = this.repository.read(guest.getGuestId());
        Assert.assertNotEquals(newguest,readGuest);
      //  Assert.assertNotEquals(guest, newguest);

    }

    @Test
    public void getAll() {
        Set<Guest> getAllGuest = this.repository.getAll();
        System.out.println("In GetAllMethod, all = " + getAllGuest.size());
        //Assert.assertFalse("Is size",getAllGuest.contains(guest));
    }
}