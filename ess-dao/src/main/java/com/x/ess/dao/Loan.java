package com.x.ess.dao;


import com.x.ess.dao.others.LoanStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@TypeAlias("loan")
public class Loan extends GenericDao {

    @Id
    private String id;

    private String bookId;
    private String userId;
    private LoanStatus loanStatus;
    private Date beginDate;
    private Date finishDate;

}