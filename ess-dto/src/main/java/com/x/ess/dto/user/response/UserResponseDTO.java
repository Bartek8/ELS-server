package com.x.ess.dto.user.response;

import com.x.ess.dao.others.UserType;
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
public class UserResponseDTO {

    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private UserType userType;
    private boolean removed;
    private List<String> Loan;
}
