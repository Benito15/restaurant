package booktest;

import ac.za.cput.domains.domainbook.Book;
import ac.za.cput.factories.bookfactory.BookFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestBook {

    @Test
    public void testBook()
    {
        String bookid = "1";
        String dte="17/04/2019";
        String tme = "09:35";

        Book book = BookFactory.getBook(bookid, dte,tme);
        System.out.println(book.toString());
        Assert.assertNotNull(book);

    }

}
