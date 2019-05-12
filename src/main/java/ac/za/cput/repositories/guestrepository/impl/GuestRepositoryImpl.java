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

   public static GuestRepositoryImpl getRepository()
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

        Guest toUpdate =  findID(guest.getGuestId());
        if(toUpdate != null) {
            this.guests.remove(toUpdate);
            return create(guest);
        }
        return null;

//        if(guests.contains(guest))
//        {
//            guests.remove(guest);
//            guest = new Guest.Builder().guestId(guest.getGuestId())
//                    .guestName(guest.getGuestName())
//                    .guestSurname(guest.getGuestSurname()).age(guest.getAge()).build();
//            this.guests.add(guest);
//
//        }
//        return guest;
    }

    ///////
    @Override
    public void delete(String s) {
       Guest guest = findID(s);
       if(guest != null)this.guests.remove(guest) ;

    }


////find the student in the set and return it if it exist
    @Override
    public Guest read( String s) {
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
//        Guest guest = null;
//        for (Guest readGuest: guests)
//            if(readGuest.getGuestName().equals(s))
//            {
//                System.out.println(readGuest.getGuestName() + readGuest.getGuestSurname());
//                guest = new Guest.Builder().guestName(s).build();
//            }
//        return guest;
    }

    public Guest findID(String s)
    {
        return guests.stream().filter(guest -> guest.getGuestId().trim().equals(s))
        .findAny().orElse(null);


    }

    @Override
    public Set<Guest> getAll() {
        return this.guests;
    }
}
