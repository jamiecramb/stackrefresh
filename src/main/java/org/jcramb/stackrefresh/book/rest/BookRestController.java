package org.jcramb.stackrefresh.book.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jcramb.stackrefresh.book.model.BookModel;
import org.jcramb.stackrefresh.book.rest.dto.BookDto;
import org.jcramb.stackrefresh.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RESTful controller that exposes CRUD operations for books; delegates to the BookService to fulfil the request.
 * 
 * @author Jamie Cramb
 */
@Controller
@RequestMapping("/books")
public class BookRestController {

    private final BookService bookService;

    @Inject
    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BookModel createBook(@RequestBody BookModel bookModel) {
        return bookService.createBook(bookModel.getName(), bookModel.getAuthor(), bookModel.getDescription());
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllBooks() {

        List<BookDto> bookDtos = new ArrayList<BookDto>();

        List<BookModel> bookModels = bookService.getAllBooks();

        for (BookModel currentBookModel : bookModels) {
            bookDtos.add(createBookDtoFromModel(currentBookModel));
        }

        return bookDtos;
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BookModel getBook(@PathVariable("bookId") Long bookId) {
        return bookService.getBookById(bookId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public BookModel updateBook(@RequestBody BookModel bookModel) {
        return bookService.updateBook(bookModel);
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBookById(bookId);
    }

    @RequestMapping(value = "/{authorName}/{bookName}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<BookModel> filterBooks(@PathVariable("authorName") String authorContains,
            @PathVariable("bookName") String bookNameContains) {
        return bookService.getBooksByNameAndAuthorContains(bookNameContains, authorContains);
    }

    /**
     * Sample method to convert a model --> DTO
     * 
     * @param bookModel Model to convert to a DTO.
     * @return DTO created from the model.
     */
    private BookDto createBookDtoFromModel(BookModel bookModel) {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookModel.getId());
        bookDto.setAuthor(bookModel.getAuthor());
        bookDto.setDescription(bookModel.getDescription());
        bookDto.setName(bookModel.getName());
        return bookDto;
    }
}