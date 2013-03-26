package org.jcramb.stackrefresh.book.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.jcramb.stackrefresh.book.model.BookModel;
import org.jcramb.stackrefresh.book.repository.BookRepository;
import org.jcramb.stackrefresh.book.service.BookService;
import org.springframework.stereotype.Service;


/**
 * Business logic tier implementation.
 * 
 * @author Jamie Cramb
 */
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /**
     * Inject the book repo implementation into the business logic implementation.
     * 
     * @param bookRepository The book repo to delegate CRUD operations to.
     */
    @Inject
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookModel createBook(String name, String author, String description) {
        BookModel newBook = new BookModel(name, description, author);

        BookModel persistedBook = bookRepository.save(newBook);

        return persistedBook;
    }

    @Override
    public BookModel getBookById(Long bookId) {
        return bookRepository.findOne(bookId);
    }

    @Override
    public BookModel updateBook(BookModel book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long bookId) {
        bookRepository.delete(bookId);
    }

    @Override
    public List<BookModel> getBooksByNameAndAuthorContains(String nameContains, String authorContains) {
        return bookRepository.getBooksByNameAndAuthorContains(nameContains, authorContains);
    }

    @Override
    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }
}