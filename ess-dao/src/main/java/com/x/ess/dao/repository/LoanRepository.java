package com.x.ess.dao.repository;

import com.x.ess.dao.Loan;
import com.x.ess.dao.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author x
 */
@Repository
public interface LoanRepository extends MongoRepository<Loan, String>, QuerydslPredicateExecutor<Loan> {


}
