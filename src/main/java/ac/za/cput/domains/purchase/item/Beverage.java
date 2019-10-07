package ac.za.cput.domains.purchase.item;

import javax.persistence.Entity;

@Entity
public class Beverage extends Item{

    private int volume;

    public Beverage() {
    }

    protected Beverage(Builder builder) {
       super(builder);
       this.volume = builder.volume;

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public static class Builder extends Item.Builder{

        int volume;

        public Builder volume(int volume)
        {
            this.volume = volume;
            return this;
        }
    public Beverage build() {
            return new Beverage(this);
        }

    }

    @Override
    public String toString() {
        return "\n Beverage{" +
                "ItemID='" + itemID + "\n" +
                "Desc='" + description + "\n" +
                "qty=" + qty + "\n"+
                "price=" + price + "\n"+
                "volume=" + volume + "\n"
               ;
    }
}
