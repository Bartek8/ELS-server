package com.x.ess.service;

import com.querydsl.core.types.Predicate;
import com.x.ess.dao.GenericDao;
import com.x.ess.dto.basic.CreateDTO;
import com.x.ess.dto.basic.UpdateDTO;
import com.x.ess.service.exceptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @param <D>
 * @param <R>
 * @param <C>
 * @param <U>
 * @author x
 */
public abstract class BasicServiceImpl<D extends GenericDao, R extends MongoRepository & QuerydslPredicateExecutor<D>, C extends CreateDTO, U extends UpdateDTO>
        implements BasicService<D, R, C, U> {

    @Autowired
    public R repository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void dropCollection(MongoTemplate mongoTemplate) {
        Class<?>[] clazz = (Class<?>[]) GenericTypeResolver
                .resolveTypeArguments(
                        getClass(),
                        BasicServiceImpl.class);
        mongoTemplate.dropCollection(clazz[0]);
    }

    @Override
    public D findById(String id) {
        Optional<D> event = repository.findById(id);
        if (event.isPresent()) {
            return event.get();
        }
        Class<?>[] clazz = (Class<?>[]) GenericTypeResolver
                .resolveTypeArguments(
                        getClass(),
                        BasicServiceImpl.class);
        throw new EntityNotFoundException(clazz[0].getName(), id);
    }

    @Override
    public D delete(D document) {
        document.setRemoved(Boolean.TRUE);
        return ((D) repository.save(document));
    }

    @Override
    public List<D> findAll(Predicate predicate) {
        Iterable<D> result = repository.findAll(predicate);
        List<D> target = new ArrayList<>();
        result.forEach(target::add);
        return target;
    }

    @Override
    public List<D> findAll() {
        return repository.findAll();
    }

    @Override
    public Page<D> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public D create(C document) {
        Class<D>[] clazz = (Class<D>[]) GenericTypeResolver
                .resolveTypeArguments(
                        getClass(),
                        BasicServiceImpl.class);


        D newDocument = modelMapper.map(document, clazz[0]);
        newDocument = (D) repository.save(newDocument);

        return newDocument;
    }

    @Override
    public D save(D document) {
        document = (D) repository.save(document);
        return document;
    }

    @Override
    public boolean saveAll(List<D> documents) {
        documents.forEach((doc) -> {
            repository.save(doc);
        });
        return true;
    }

    @Override
    public D update(D existingDocument, U updatedDocument) {
        Class<D>[] clazz = (Class<D>[]) GenericTypeResolver
                .resolveTypeArguments(
                        getClass(),
                        BasicServiceImpl.class);
        D mappedDocument = modelMapper.map(updatedDocument, clazz[0]);
        D mapOnlyChangedFields = mapOnlyChangedFields(existingDocument, mappedDocument);
        mapOnlyChangedFields = (D) repository.save(mapOnlyChangedFields);
        return mapOnlyChangedFields;
    }



    @Override
    public D update(D existingDocument, D updatedDocument) {
        D mapOnlyChangedFields = mapOnlyChangedFields(existingDocument, updatedDocument);
        mapOnlyChangedFields = (D) repository.save(mapOnlyChangedFields);
        return mapOnlyChangedFields;
    }

    public D mapOnlyChangedFields(D existingDocument, D updatingDocument) {
        Field[] declaredFields = existingDocument.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            try {
                field.setAccessible(true);
                if (field.get(updatingDocument) != null) {
                    field.set(existingDocument, field.get(updatingDocument));
                }
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(BasicServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return existingDocument;
    }

    @Override
    public long count() {
        return repository.count();
    }

    public R getRepository() {
        return this.repository;
    }

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

}
