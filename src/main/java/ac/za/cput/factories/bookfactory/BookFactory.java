package ac.za.cput.factories.bookfactory;

import ac.za.cput.domains.domainbook.Book;
import ac.za.cput.util.Misc;

public class BookFactory {

    public static Book getBook(String bookID, String dte,String tme)
    {
        return new Book.Builder().tme(tme)
                .dte(dte)
                .bookingID(Misc.generateId()).build();

    }



}
