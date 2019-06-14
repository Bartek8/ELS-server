package com.x.ess.app.controller;

import com.querydsl.core.types.Predicate;
import com.x.ess.dao.Book;
import com.x.ess.dto.book.request.CreateBookRequestDTO;
import com.x.ess.dto.book.request.UpdateBookRequestDTO;
import com.x.ess.dto.book.response.BookResponseDTO;
import com.x.ess.service.book.BookService;
import com.x.ess.service.exceptions.EntityNotFoundException;
import com.x.ess.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author x
 */
@RestController
@RequestMapping(value = "/book", produces = "application/json")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBook(@PathVariable String id){

        Book book = bookService.findById(id);
        if (book == null) {
            throw new EntityNotFoundException("BookController", id);
        }

        return new ResponseEntity<>(
                bookService.convertToResponseDTO(book), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "/author/{authorName}")
    public ResponseEntity<List<BookResponseDTO>> listAllBooksByAuthor(@PathVariable String authorName) {

        List<Book> books = bookService.findAllByAuthor(authorName);

        List<BookResponseDTO> response = books.stream()
                .map(bookService::convertToResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                response,
                new HttpHeaders(),
                HttpStatus.OK);



    }

    @GetMapping(value = "/book/{bookName}")
    public ResponseEntity<List<BookResponseDTO>> listAllBooksByName(@PathVariable String bookName) {

        List<Book> books = bookService.findAllByName(bookName);

        List<BookResponseDTO> response = books.stream()
                .map(bookService::convertToResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                response,
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<BookResponseDTO>> listAllBooks(@QuerydslPredicate(root = Book.class) Predicate predicate) {


        List<Book> books = bookService.findAll(predicate);

        List<BookResponseDTO> response = books.stream()
                .map(bookService::convertToResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                response,
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<BookResponseDTO> createBook(@Valid @RequestBody CreateBookRequestDTO request) {

        Book newBook = bookService.create(request);

        boolean b = bookService.validateName(request.getName());
//        String authorId = request.getAuthorId();



        return new ResponseEntity<>(
                bookService.convertToResponseDTO(newBook),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }


    @PostMapping(value = "/update/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable String id,
                                                      @Valid @RequestBody UpdateBookRequestDTO request) {

        Book book = bookService.findById(id);

        if (book == null) {
            throw new EntityNotFoundException("BookController", id);
        }

        Book updatedBook = bookService.update(book, request);

        return new ResponseEntity<>(
                bookService.convertToResponseDTO(updatedBook),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BookResponseDTO> deleteBook(@PathVariable String id) {

        Book book = bookService.findById(id);

        if (book == null) {
            throw new EntityNotFoundException("BookController", id);
        }

        Book deletedBook = bookService.delete(book);

        return new ResponseEntity<>(
                bookService.convertToResponseDTO(deletedBook),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }
}