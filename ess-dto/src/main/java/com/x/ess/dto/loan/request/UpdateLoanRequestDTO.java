package com.x.ess.dto.loan.request;

import com.x.ess.dao.others.Costs;
import com.x.ess.dao.others.OrderStatus;
import com.x.ess.dto.basic.UpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;import com.x.ess.dao.others.OrderStatus;
/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateLoanRequestDTO implements UpdateDTO {

    private OrderStatus orderStatus;
    private Date finishDate;
}
