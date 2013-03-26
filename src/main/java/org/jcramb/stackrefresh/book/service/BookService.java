package org.jcramb.stackrefresh.book.service;

import java.util.List;

import org.jcramb.stackrefresh.book.model.BookModel;


/**
 * Business logic tier contract.
 * 
 * @author Jamie Cramb
 */
public interface BookService {

    BookModel createBook(String name, String author, String description);

    BookModel getBookById(Long bookId);

    BookModel updateBook(BookModel book);

    void deleteBookById(Long bookId);

    List<BookModel> getBooksByNameAndAuthorContains(String nameContains, String authorContains);

    List<BookModel> getAllBooks();
}