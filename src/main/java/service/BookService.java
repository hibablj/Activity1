package app.service;

import org.springframework.stereotype.Service;
import app.model.Book;
import app.repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public void save(Book book) { repository.save(book); }
    public void update(Book book) { repository.update(book); }
    public void delete(int id) { repository.delete(id); }
    public Book findById(int id) { return repository.findById(id); }
    public long count() { return repository.count(); }
    public List<Book> findAll() { return repository.findAllByOrderByTitle(); }
    public List<Book> findByAuthor(String author) { return repository.findByAuthor(author); }
}
