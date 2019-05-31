package com.x.ess.dto.loan.response;

import com.x.ess.dao.Book;
import com.x.ess.dao.User;
import com.x.ess.dao.others.LoanStatus;
import com.x.ess.dto.basic.CreateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoanResponseDTO implements CreateDTO {

    @Id
    private String id;

    private String bookId;
    private String userId;
    private LoanStatus loanStatus;
    private Date beginDate;
    private Date finishDate;
}
