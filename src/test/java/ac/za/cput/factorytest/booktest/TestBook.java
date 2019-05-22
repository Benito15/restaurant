package ac.za.cput.factorytest.booktest;

import ac.za.cput.domains.book.Book;
import ac.za.cput.factory.bookfactory.BookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class TestBook {

    @Test
    public void testBook()
    {
        String bookid = "1";
        Date dte = new Date();
        String tme = "09:35";

        Book book = BookFactory.getBook(bookid,dte,tme);
        System.out.println(book.toString());
        Assert.assertNotNull(book);

    }

}
