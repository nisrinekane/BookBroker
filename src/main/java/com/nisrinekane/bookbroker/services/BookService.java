package com.nisrinekane.bookbroker.services;


import com.nisrinekane.bookbroker.models.Book;
import com.nisrinekane.bookbroker.models.User;
import com.nisrinekane.bookbroker.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //create a book
    public void createBook(Book book, User owner) {
        book.setOwner(owner);
        bookRepository.save(book);
    }

    //retrieve a book
    public Book findBook(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    //return all books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    //return all borrowed books
    public List<Book> allBorrowedBooks(User user) {
        return bookRepository.findAll().stream().filter(
                book -> user == book.getBorrower()).collect(Collectors.toList());
    }

    //update a book
    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    // delete all books
    public Book deleteBook(long id) {
        bookRepository.deleteById(id);
        return null;
    }

    //borrow a book
    public void borrowBook(Book book, User borrower) {
        book.setBorrower(borrower);
        bookRepository.save(book);
    }

    // return
    public void returnBook(Book book) {
        book.setBorrower(null);
        bookRepository.save(book);
    }

}
