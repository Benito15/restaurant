package ac.za.cput.domains.guest;

import java.util.Objects;

public class Guest {
    private String guestId, guestName, guestSurname;
    private int age;
   // private Set<Guest> guest;

    private Guest(){}



    private Guest(Builder builder)
    {
     this.guestId = builder.guestId;
     this.guestName = builder.guestName;
     this.guestSurname = builder.guestSurname;
     this.age = builder.age;

    }


    public String getGuestId() {
        return guestId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getGuestSurname() {
        return guestSurname;
    }

    public int getAge() {
        return age;
    }

    public static class Builder{

    private String guestId, guestName,guestSurname;
    private int age;

    public Builder guestId(String guestId)
    {
        this.guestId = guestId;
        return this;

    }

    public Builder guestName(String guestName)
    {
        this.guestName = guestName;
        return this;

    }

        public Builder guestSurname(String guestSurname)
        {
            this.guestSurname = guestSurname;
            return this;

        }

        public Builder age(int age)
        {
            this.age=age;
            return this;

        }



        public Guest build()
        {
            return new Guest(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Guest)) return false;
        Guest guest = (Guest) o;
        return Objects.equals(getGuestId(), guest.getGuestId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGuestId());
    }

    @Override
    public String toString() {
        return "Guest{" +
                "guestId='" + guestId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", guestSurname='" + guestSurname + '\'' +
                ", age=" + age +
                '}';
    }
}
