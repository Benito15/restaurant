package ac.za.cput.repositories.guestrepository.impl;

import ac.za.cput.domains.domainguest.Guest;
import ac.za.cput.repositories.guestrepository.GuestRepository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GuestRepositoryImpl implements GuestRepository {

    private static GuestRepositoryImpl repository = null;
    private Set<Guest> guests;

    private GuestRepositoryImpl()
    {
        this.guests = new HashSet<>();

    }

   public static GuestRepository getRepository()
   {
       if(repository == null) repository = new GuestRepositoryImpl();
       return repository;

   }

    @Override
    public Guest create(Guest guest) {
        this.guests.add(guest);
        return guest;
    }

    @Override
    public Guest update(Guest guest) {
        return null;
    }

    ///////
    @Override
    public void delete(String s) {
       Guest guests = findID(s);
        this.guests.remove(guests);

    }


////find the student in the set and return it if it exist
    @Override
    public Guest read(String s) {
//    Iterator<Guest> itr = guests.iterator();
//        while(itr.hasNext())
//        {
//            if(itr.next().getGuestId().contains(s))
//            {
//                return null;
//            }else
//                return null;
//        }


        Guest guests = findID(s);
        if(guests.equals(s))
        {
            return guests;
        }else
            {
                return null;
            }


//        return guests.stream().filter(p -> p.getGuestId().equals(s))
//                .findFirst().orElse(null);
//        return guests.stream().filter(t-> t.getGuestId()
//                .equals(s)).findFirst().orElse(null);

    }

    public Guest findID(String s)
    {
        return guests.stream().filter(p -> p.getGuestId().equals(s))
        .findFirst().orElse(null);


    }

    @Override
    public Set<Guest> getAll() {
        return this.guests;
    }
}
