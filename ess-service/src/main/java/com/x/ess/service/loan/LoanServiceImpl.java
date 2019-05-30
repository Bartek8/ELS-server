package com.x.ess.service.loan;

import com.x.ess.dao.Loan;
import com.x.ess.dao.User;
import com.x.ess.dao.repository.LoanRepository;
import com.x.ess.dto.loan.request.CreateLoanRequestDTO;
import com.x.ess.dto.loan.request.UpdateLoanRequestDTO;
import com.x.ess.dto.loan.response.LoanResponseDTO;
import com.x.ess.service.BasicServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author x
 */
@Service
public class LoanServiceImpl
        extends BasicServiceImpl<Loan, LoanRepository, CreateLoanRequestDTO, UpdateLoanRequestDTO>
        implements LoanService {

    @Autowired
    public ModelMapper modelMapper;


    @Override
    public LoanResponseDTO convertToResponseDTO(Loan loan) {

        LoanResponseDTO mappedLoan = modelMapper.map(loan, LoanResponseDTO.class);
        return mappedLoan;
    }


}
