package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.service.BookService;
import app.service.LibraryService;
import app.ui.ConsoleUI;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {

    private final BookService bookService;
    private final LibraryService libraryService;

    public MainApplication(BookService bookService, LibraryService libraryService) {
        this.bookService = bookService;
        this.libraryService = libraryService;
    }

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) {
        ConsoleUI ui = new ConsoleUI(bookService, libraryService);
        ui.start();
    }
}
