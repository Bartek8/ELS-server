package com.x.ess.dao.repository;

import com.x.ess.dao.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author x
 */
@Repository
public interface BookRepository extends MongoRepository<Book, String>, QuerydslPredicateExecutor<Book> {

        List<Book> findAllByAuthor(String author);

        List<Book> findAllByName(String name);

}
