package com.x.ess.dto.loan.request;

import com.x.ess.dao.others.LoanStatus;
import com.x.ess.dto.basic.UpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateLoanRequestDTO implements UpdateDTO {

    private LoanStatus loanStatus;
    private Date finishDate;
}
