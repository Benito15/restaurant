package ac.za.cput.domains.guest;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Guest {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String guestId;
    @Column(name = "Name" )
    private String guestName;
    @Column(name = "Surname")
    private String guestSurname;
    @Column(name = "age")
    private int age;

    public Guest(){}



    public Guest(Builder builder)
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

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setGuestSurname(String guestSurname) {
        this.guestSurname = guestSurname;
    }

    public void setAge(int age) {
        this.age = age;
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

        public Builder copy(Guest guest) {
            this.guestId = guest.guestId;
            this.guestName = guest.guestName;
            this.guestSurname= guest.guestSurname;
            this.age= guest.age;
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
