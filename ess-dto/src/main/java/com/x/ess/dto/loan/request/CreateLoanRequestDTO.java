package com.x.ess.dto.loan.request;

import com.x.ess.dto.basic.CreateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.x.ess.dao.others.OrderStatus;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLoanRequestDTO implements CreateDTO {

    @NotNull
    @NotEmpty
    private String userId;

    @NotNull
    @NotEmpty
    private String bookId;

    @NotNull
    @NotEmpty
    private OrderStatus orderStatus;
    private Date beginDate;
    private Date finishDate;

}

