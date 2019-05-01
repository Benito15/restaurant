package ac.za.cput.repositories.bookrepository;

import ac.za.cput.domains.domainbook.Book;
import ac.za.cput.repositories.IRepository;

import java.util.Set;

public interface BookRepository extends IRepository <Book, String>{

    Set<Book> getall();
}
