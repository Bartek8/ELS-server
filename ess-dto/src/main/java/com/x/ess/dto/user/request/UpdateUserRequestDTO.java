package com.x.ess.dto.user.request;

import com.x.ess.dao.others.UserType;
import com.x.ess.dto.basic.UpdateDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateUserRequestDTO implements UpdateDTO {

    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private UserType userType;
    private List<String> Loan;
}
