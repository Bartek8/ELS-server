package com.x.ess.service.loan;

import com.x.ess.dao.Loan;
import com.x.ess.dao.User;
import com.x.ess.dao.repository.LoanRepository;
import com.x.ess.dto.loan.request.CreateLoanRequestDTO;
import com.x.ess.dto.loan.request.UpdateLoanRequestDTO;
import com.x.ess.dto.loan.response.LoanResponseDTO;
import com.x.ess.service.BasicService;

import java.util.List;

/**
 * @author x
 */
public interface LoanService
        extends BasicService<Loan, LoanRepository, CreateLoanRequestDTO, UpdateLoanRequestDTO> {

    LoanResponseDTO convertToResponseDTO(Loan loan);

    @Override
    Loan create(CreateLoanRequestDTO document);

    @Override
    Loan update(Loan existingDocument, UpdateLoanRequestDTO document);


}
