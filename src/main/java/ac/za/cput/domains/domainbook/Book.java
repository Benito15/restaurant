package ac.za.cput.domains.domainbook;


import java.util.Date;
import java.util.Objects;

public class Book {


    private String bookingID;
    private Date dte;
    private String tme;


    private Book(){}

    private Book(Builder builder) {
        this.bookingID = builder.bookingID;
        this.dte = builder.dte;
        this.tme = builder.tme;

    }

    public String getBookingID() {
        return bookingID;
    }

    public Date getDte() {
        return dte;
    }

    public String getTme() {
        return tme;
    }


    public static class Builder{


        private String bookingID, tme;
        private Date dte;


        public Builder bookingID(String bookingID)
        {
            this.bookingID = bookingID;
            return this;
        }

        public Builder dte(Date dte)
        {
            this.dte = new Date(dte.getTime());
            return this;
        }

        public Builder tme(String tme)
        {

            this.tme = tme;
            return this;
        }




        public Book build()
        {return new Book(this);}


    }

    @Override
    public String toString() {
        return "Book{" +
                "bookingID='" + bookingID + '\'' +
                ", dte='" + dte + '\'' +
                ", tme='" + tme + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Objects.equals(getBookingID(), book.getBookingID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBookingID());
    }
}


