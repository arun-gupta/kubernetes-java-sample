package org.example.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @arungupta
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private BookRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        String isbn = "978-1-4919-1889-0";
        repository.save(new Book(isbn, "Minecraft Modding with Forge", "29.99"));

        Book book = repository.findByIsbn(isbn);
        System.out.println(book);
    }
}
