package ac.za.cput.domains.restaurant;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Restaurant {

    @Id
    private String resID;
    private String name;
    private int totEmployees;

    public Restaurant(){}

    public Restaurant(Builder builder)
    {

        this.resID=builder.resID;
        this.name=builder.name;
        this.totEmployees=builder.totEmployees;
    }

    public String getResID() {
        return resID;
    }

    public String getName() {
        return name;
    }

    public int getTotEmployees() {
        return totEmployees;
    }

    public void setResID(String resID) {
        this.resID = resID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotEmployees(int totEmployees) {
        this.totEmployees = totEmployees;
    }

    public static class Builder
    {

        private String resID,name;
        private int totEmployees;


        public Builder resID(String resID)
        {
            this.resID=resID;
            return this;

        }

        public Builder name(String name)
        {
            this.name=name;
            return this;

        }

        public Builder totEmployees(int totEmployees)
        {
            this.totEmployees=totEmployees;
            return this;

        }

        public Builder copy(Restaurant restaurant) {
            this.resID=restaurant.resID;
            this.name=restaurant.name;
            this.totEmployees=restaurant.totEmployees;
            return this;
        }

        public Restaurant build()
        {
            return new Restaurant(this);
        }

    }

    @Override
    public String toString() {
        return "\n Restaurant" +
                "resID= " + resID + "\n" +
                "Name= " + name + "\n" +
                "Total Employees= " + totEmployees + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Restaurant)) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(getResID(), that.getResID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getResID());
    }
}
