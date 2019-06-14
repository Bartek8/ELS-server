package com.x.ess.service.book;

import com.x.ess.dao.Book;
import com.x.ess.dao.repository.BookRepository;
import com.x.ess.dto.book.request.CreateBookRequestDTO;
import com.x.ess.dto.book.request.UpdateBookRequestDTO;
import com.x.ess.dto.book.response.BookResponseDTO;
import com.x.ess.service.BasicService;

import java.util.List;

/**
 * @author x
 */
public interface BookService
        extends BasicService<Book, BookRepository, CreateBookRequestDTO, UpdateBookRequestDTO> {

    public BookResponseDTO convertToResponseDTO(Book book);

    public boolean validateName(String name);

    public List<Book> findAllByAuthor(String author);

    public List<Book> findAllByName(String name);
}
