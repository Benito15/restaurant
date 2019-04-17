package ac.za.cput.domains.domainbook;



public class Book {


    private String bookingID;
    private String dte;
    private String tme;


    private Book(){}

    public Book(Builder builder) {
        this.bookingID = builder.bookingID;
        this.dte = builder.dte;
        this.tme = builder.tme;

    }

    public String getBookingID() {
        return bookingID;
    }

    public String getDte() {
        return dte;
    }

    public String getTme() {
        return tme;
    }


    public static class Builder{


        private String bookingID, dte, tme;


        public Builder bookingID(String bookingID)
        {
            this.bookingID = bookingID;
            return this;
        }

        public Builder dte(String dte)
        {
            this.dte = dte;
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
}


