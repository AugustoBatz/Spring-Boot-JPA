/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.test.mytest.resource;

import com.test.mytest.model.Users;
import com.test.mytest.repository.UsersRepository;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author augustobatz
 */

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(
            value = "/all",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @Operation(summary = "GET list users",
            description = "obtiene la lista de usuario")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Users> persist(@RequestBody final Users users) {
        if (users.getName().equals("name")) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE);
        }
        usersRepository.save(users);
        return usersRepository.findAll();
    }

}
