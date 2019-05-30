package com.x.ess.dao;

import com.x.ess.dao.others.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author x
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
@TypeAlias("User")
public class User extends GenericDao {

    @Id
    private String id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private UserType userType;
    //private UserLoan userLoan;
    private List<String> Loan;

}
