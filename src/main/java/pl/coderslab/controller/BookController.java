package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.Service.BookService;
import pl.coderslab.Service.MemoryBookService;
import pl.coderslab.model.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookService memoryBookService;

    @Autowired
    public BookController(BookService memoryBookService) {
        this.memoryBookService = memoryBookService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @GetMapping
    public List<Book> bookList () {
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    public Book getBookById (@PathVariable long id ) {
        return memoryBookService.getById(id);
    }
    @PostMapping
    public void addBook (@RequestBody Book book) {
        memoryBookService.add(book);
    }

    @PutMapping("/{id}")
    public void putBook (@PathVariable long id, @RequestBody Book book){
        memoryBookService.edit( id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook (@PathVariable long id){
        memoryBookService.delete(id);
    }
}
