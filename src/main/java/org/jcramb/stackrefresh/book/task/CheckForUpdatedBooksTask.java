package org.jcramb.stackrefresh.book.task;

import java.util.List;

import javax.inject.Inject;

import org.jcramb.stackrefresh.book.model.BookModel;
import org.jcramb.stackrefresh.book.service.BookService;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Repeating task that checks for updated books. Delegates to the BookService to perform the lookup.
 * 
 * @author Jamie Cramb
 */
public class CheckForUpdatedBooksTask {

    private final BookService bookService;

    @Inject
    public CheckForUpdatedBooksTask(BookService bookService) {
        this.bookService = bookService;
    }

    @Scheduled(fixedDelay = 5000)
    public void findFilteredBooks() {
        List<BookModel> booksFound = bookService.getBooksByNameAndAuthorContains("UPDATED", "");

        System.out.println("\n\n");
        if (booksFound == null || booksFound.size() < 1) {
            System.out.println("**** No Books Found...\n");
            return;
        }

        System.out.println("Books Found:");
        for (BookModel currentBook : booksFound) {
            System.out.println("\t" + currentBook);
        }

        System.out.println("\n\n");
    }
}