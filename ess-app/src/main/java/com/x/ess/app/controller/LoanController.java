package com.x.ess.app.controller;

import com.querydsl.core.types.Predicate;
import com.x.ess.dao.Loan;
import com.x.ess.dao.User;
import com.x.ess.dto.loan.request.CreateLoanRequestDTO;
import com.x.ess.dto.loan.request.UpdateLoanRequestDTO;
import com.x.ess.dto.loan.response.LoanResponseDTO;
import com.x.ess.service.exceptions.EntityNotFoundException;
import com.x.ess.service.loan.LoanService;
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
@RequestMapping(value = "/loan", produces = "application/json")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDTO> getLoan(@PathVariable String id) {

        Loan loan = loanService.findById(id);
        if (loan == null) {
            throw new EntityNotFoundException("LoanController", id);
        }

        return new ResponseEntity<>(
                loanService.convertToResponseDTO(loan), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<LoanResponseDTO>> listAllBooks(@QuerydslPredicate(root = Loan.class) Predicate predicate) {


        List<Loan> books = loanService.findAll(predicate);

        List<LoanResponseDTO> response = books.stream()
                .map(loanService::convertToResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                response,
                new HttpHeaders(),
                HttpStatus.OK);
    }


    @PostMapping(value = "/create")
    public ResponseEntity<LoanResponseDTO> createLoan(@Valid @RequestBody CreateLoanRequestDTO request) {

        Loan newLoan = loanService.create(request);

        return new ResponseEntity<>(
                loanService.convertToResponseDTO(newLoan),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<LoanResponseDTO> updateLoan(@PathVariable String id,
                                                        @Valid @RequestBody UpdateLoanRequestDTO request) {

        Loan loan = loanService.findById(id);

        if (loan == null) {
            throw new EntityNotFoundException("LoanController", id);
        }

        Loan updatedLoan = loanService.update(loan, request);

        return new ResponseEntity<>(
                loanService.convertToResponseDTO(updatedLoan),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LoanResponseDTO> deleteLoan(@PathVariable String id) {

        Loan loan = loanService.findById(id);

        if (loan == null) {
            throw new EntityNotFoundException("LoanController", id);
        }

        Loan deletedLoan = loanService.delete(loan);

        return new ResponseEntity<>(
                loanService.convertToResponseDTO(deletedLoan),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }
}
