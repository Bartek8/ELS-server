package com.x.ess.service.user;

import com.x.ess.dao.User;
import com.x.ess.dao.repository.UserRepository;
import com.x.ess.dto.user.request.CreateUserRequestDTO;
import com.x.ess.dto.user.request.UpdateUserRequestDTO;
import com.x.ess.dto.user.response.UserResponseDTO;
import com.x.ess.service.BasicService;

import java.util.List;

/**
 * @author x
 */
public interface UserService
        extends BasicService<User, UserRepository, CreateUserRequestDTO, UpdateUserRequestDTO> {

    UserResponseDTO convertToResponseDTO(User user);

    User findByLogin(String login);

    public List<User> findAllByName(String name);

}
