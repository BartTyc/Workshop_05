package pl.coderslab.Service;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getList();
    public Book getById(long id);
    public void add (Book book);
    public void edit (long id, Book book);
    public void delete (long id);
}
