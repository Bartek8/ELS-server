package com.x.ess.service;

import com.querydsl.core.types.Predicate;
import com.x.ess.dao.GenericDao;
import com.x.ess.dto.basic.CreateDTO;
import com.x.ess.dto.basic.UpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

/**
 * @author x
 */
public interface BasicService<D extends GenericDao, R extends MongoRepository & QuerydslPredicateExecutor<D>,
        C extends CreateDTO, U extends UpdateDTO> {

    D create(C doc);

    D save(D doc);

    boolean saveAll(List<D> docs);

    D findById(String id);

    List<D> findAll();

    Page<D> findAll(Pageable pageable);

    List<D> findAll(Predicate predicate) ;

    D update(D existingDoc, U updatedDoc);

    D update(D existingDocument, D updatedDocument);

    D delete(D doc);

    void deleteAll();

    void dropCollection(MongoTemplate mongoTemplate);

    long count();

}
