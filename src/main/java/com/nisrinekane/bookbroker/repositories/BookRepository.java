package com.nisrinekane.bookbroker.repositories;

import com.nisrinekane.bookbroker.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//inherit from crud repository
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
}
