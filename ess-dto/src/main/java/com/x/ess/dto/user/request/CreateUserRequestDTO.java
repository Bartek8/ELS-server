package com.x.ess.dto.user.request;

import com.x.ess.dao.others.UserType;
import com.x.ess.dto.basic.CreateDTO;
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
public class CreateUserRequestDTO implements CreateDTO {

    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private UserType userType;
    private List<String> Loan;

}
