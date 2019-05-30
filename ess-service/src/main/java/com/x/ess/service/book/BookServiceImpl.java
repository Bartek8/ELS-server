package com.x.ess.service.book;

import com.x.ess.dao.Book;
import com.x.ess.dao.repository.BookRepository;
import com.x.ess.dto.book.request.CreateBookRequestDTO;
import com.x.ess.dto.book.request.UpdateBookRequestDTO;
import com.x.ess.dto.book.response.BookResponseDTO;
import com.x.ess.service.BasicServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author x
 */
@Service
public class BookServiceImpl
        extends BasicServiceImpl<Book, BookRepository, CreateBookRequestDTO, UpdateBookRequestDTO>
        implements BookService {

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public BookResponseDTO convertToResponseDTO(Book book) {

        BookResponseDTO mappedClient = modelMapper.map(book, BookResponseDTO.class);
        return mappedClient;
    }

    @Override
    public boolean validateName(String name) {

        boolean a = name.contains("a");
        if(a){
            return true;
        }
        return false;
    }

    @Override
    public List<Book> findAllByAuthor(String author) {

        List<Book> allByAuthor = repository.findAllByAuthor(author);
        return allByAuthor;

    }

    @Override
    public List<Book> findAllByName(String name) {
        return repository.findAllByName(name);
    }


}
