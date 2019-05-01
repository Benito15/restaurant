package ac.za.cput.repositories.bookrepository.impl;

import ac.za.cput.domains.domainbook.Book;
import ac.za.cput.repositories.bookrepository.BookRepository;

import java.util.HashSet;
import java.util.Set;

public class BookRepositoryImpl implements BookRepository {

    private static BookRepositoryImpl repository = null;
    private Set<Book> books;

    private BookRepositoryImpl()
    {
        this.books = new HashSet<>();
    }

    public static BookRepositoryImpl getRepository()
    {
        if(repository == null) repository = new BookRepositoryImpl();
        return repository;
    }

    @Override
    public Set<Book> getall() {
        return this.books;
    }

    @Override
    public Book create(Book book) {
        this.books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(String s) {
        Book book = findID(s);
        this.books.remove(book);

    }

    @Override
    public Book read(String s) {
        Book books = findID(s);
        if(books.equals(s))return books;
        else return null;
    }

    public Book findID(String s)
    {
        return books.stream().filter(b -> b.getBookingID().equals(s))
                .findFirst().orElse(null);
    }

}
