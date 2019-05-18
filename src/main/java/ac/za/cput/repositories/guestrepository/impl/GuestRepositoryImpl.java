package ac.za.cput.repositories.guestrepository.impl;

import ac.za.cput.domains.guest.Guest;
import ac.za.cput.repositories.guestrepository.GuestRepository;

import java.util.*;

public class GuestRepositoryImpl implements GuestRepository {

    private static GuestRepositoryImpl repository = null;
    private Map<String,Guest> guests;

    private GuestRepositoryImpl()
    {
        this.guests = new HashMap<>();

    }

   public static GuestRepositoryImpl getRepository()
   {
       if(repository == null) repository = new GuestRepositoryImpl();
       return repository;

   }

    @Override
    public Guest create(Guest guest) {
        this.guests.put(guest.getGuestId(),guest);
        return guest;
    }

    @Override
    public Guest update(Guest guest) {

//        Guest toUpdate =  findID(guest.getGuestId());
//        if(toUpdate != null) {
//            this.guests.remove(toUpdate);
//            return create(guest);
//        }
//        return null;

        this.guests.replace(guest.getGuestId(), guest);
        return this.guests.get(guest.getGuestId());



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
      this.guests.remove(s);

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


        return this.guests.get(s);


//        Guest guest = null;
//        for (Guest readGuest: guests)
//            if(readGuest.getGuestName().equals(s))
//            {
//                System.out.println(readGuest.getGuestName() + readGuest.getGuestSurname());
//                guest = new Guest.Builder().guestName(s).build();
//            }
//        return guest;
    }

//    public Guest findID(String s)
//    {
//        return guests.stream().filter(guest -> guest.getGuestId().trim().equals(s))
//        .findAny().orElse(null);
//
//
//    }

    @Override
    public Set<Guest> getAll() {
        Collection<Guest> guests = this.guests.values();
        Set<Guest> set = new HashSet<>();
        set.addAll(guests);
        return set;
    }
}
