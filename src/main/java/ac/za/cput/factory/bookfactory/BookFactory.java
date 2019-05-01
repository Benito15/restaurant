package ac.za.cput.factory.bookfactory;

import ac.za.cput.domains.domainbook.Book;
import ac.za.cput.util.Misc;

import java.util.Date;

public class BookFactory {

    public static Book getBook(String bookID, Date dte,String tme)
    {
        return new Book.Builder().tme(tme)
                .dte(dte)
                .bookingID(Misc.generateId()).build();

    }



}
