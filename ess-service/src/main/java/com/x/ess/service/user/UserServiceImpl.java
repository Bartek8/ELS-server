package com.x.ess.service.user;

import com.x.ess.dao.User;
import com.x.ess.dao.repository.UserRepository;
import com.x.ess.dto.user.request.CreateUserRequestDTO;
import com.x.ess.dto.user.request.UpdateUserRequestDTO;
import com.x.ess.dto.user.response.UserResponseDTO;
import com.x.ess.service.BasicServiceImpl;
import com.x.ess.service.exceptions.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author x
 */
@Service
public class UserServiceImpl
        extends BasicServiceImpl<User, UserRepository, CreateUserRequestDTO, UpdateUserRequestDTO>
        implements UserService {

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public UserResponseDTO convertToResponseDTO(User user) {

        UserResponseDTO mappedUser = modelMapper.map(user, UserResponseDTO.class);
        return mappedUser;
    }

    @Override
    public User findByLogin(String login) {

        User user = repository.findByLogin(login);
        if (user == null) {
            throw new EntityNotFoundException("User", login);
        }

        return user;
    }

    @Override
    public List<User> findAllByName(String name) {
        return repository.findAllByName(name);
    }

}


