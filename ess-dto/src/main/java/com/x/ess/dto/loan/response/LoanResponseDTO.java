package com.x.ess.dto.loan.response;

import com.x.ess.dao.Book;
import com.x.ess.dao.User;
import com.x.ess.dao.others.OrderStatus;
import com.x.ess.dto.basic.CreateDTO;
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
public class LoanResponseDTO implements CreateDTO {


    private String id;
    private Book book;
    private User user;
    private OrderStatus orderStatus;
    private Date beginDate;
    private Date finishDate;
}
