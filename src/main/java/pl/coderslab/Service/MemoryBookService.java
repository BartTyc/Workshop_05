package pl.coderslab.Service;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService{
    private List<Book> list;
    private long nextId = 3;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }
    public List<Book> getList() {return list;}
    public void setList(List<Book> list) {this.list = list;}

    public Book getById(long id) {
        for (Book book : list){
            if (book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public void add (Book book){
        book.setId(++nextId);
        list.add(book);
    }

    public void edit (long id, Book book){
        for (Book book1 : list){
            if (book1.getId() == id){
                book1.setAuthor(book.getAuthor());
                book1.setIsbn(book.getIsbn());
                book1.setPublisher(book1.getPublisher());
                book1.setTitle(book.getTitle());
                book1.setType(book.getType());
            }
        }
    }

    public void delete (long id) {
        for (Book book : list){
            if (book.getId() == id){
                list.remove(book);
            }
        }
    }
}
