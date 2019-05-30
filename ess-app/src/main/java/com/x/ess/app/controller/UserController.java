package com.x.ess.app.controller;

import com.x.ess.dao.User;
import com.x.ess.dto.user.request.CreateUserRequestDTO;
import com.x.ess.dto.user.request.UpdateUserRequestDTO;
import com.x.ess.dto.user.response.UserResponseDTO;
import com.x.ess.service.exceptions.EntityNotFoundException;
import com.x.ess.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author x
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable String id) {

        User user = userService.findById(id);
        if (user == null) {
            throw new EntityNotFoundException("UserController", id);
        }

        return new ResponseEntity<>(
                userService.convertToResponseDTO(user), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<List<UserResponseDTO>> listAllUsers() {

        List<User> users = userService.findAll();

        List<UserResponseDTO> response = users.stream()
                .map(userService::convertToResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                response,
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @GetMapping(value = "/user/{userName}")
    public ResponseEntity<List<UserResponseDTO>> listAllUserByName(@PathVariable String userName) {

        List<User> books = userService.findAllByName(userName);

        List<UserResponseDTO> response = books.stream()
                .map(userService::convertToResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(
                response,
                new HttpHeaders(),
                HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody CreateUserRequestDTO request) {

        User newUser = userService.create(request);

        return new ResponseEntity<>(
                userService.convertToResponseDTO(newUser),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable String id,
                                                      @Valid @RequestBody UpdateUserRequestDTO request) {

        User user = userService.findById(id);

        if (user == null) {
            throw new EntityNotFoundException("UserController", id);
        }

        User updatedUser = userService.update(user, request);

        return new ResponseEntity<>(
                userService.convertToResponseDTO(updatedUser),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable String id) {

        User user = userService.findById(id);

        if (user == null) {
            throw new EntityNotFoundException("UserController", id);
        }

        User deletedUser = userService.delete(user);

        return new ResponseEntity<>(
                userService.convertToResponseDTO(deletedUser),
                new HttpHeaders(),
                HttpStatus.CREATED);
    }

}
