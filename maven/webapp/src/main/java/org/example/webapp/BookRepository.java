package org.example.webapp;

import org.springframework.data.couchbase.repository.CouchbaseRepository;

/**
 * @author arungupta
 */
public interface BookRepository extends CouchbaseRepository<Book, String> {
    Book findByIsbn(String isbn);
}
