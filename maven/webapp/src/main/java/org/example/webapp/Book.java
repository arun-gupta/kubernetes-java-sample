package org.example.webapp;

import com.couchbase.client.java.repository.annotation.Id;

/**
 * @author arungupta
 */
public class Book {
    
    @Id
    private String key;
    
    private String isbn;
    private String name;
    private String cost;

    public Book(String isbn, String name, String cost) {
        this.key = isbn;
        this.isbn = isbn;
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Book{" + "isbn=" + isbn + ", name=" + name + ", cost=" + cost + '}';
    }
    
}
