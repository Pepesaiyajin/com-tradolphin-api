package com.fakex.bitcoin.controller;


import com.fakex.bitcoin.models.users.User;
import com.fakex.bitcoin.models.users.Wallet;
import com.fakex.bitcoin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {

    private final static String EMAIL = "email";
    private final static String FIRST_NAME = "firstName";
    private final static String LAST_NAME = "lastName";
    private final static String PASSWORD = "password";
    private UserRepository usersRepository;

    @Autowired
    public RegisterController(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @PostMapping("/add-user")
    public ResponseEntity<String> addUser(HttpServletRequest request) {
        User user = createUserFromRequest(request);
        if (usersRepository.findByEmail(user.getEmail()).isEmpty()) {
            usersRepository.save(user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    private User createUserFromRequest(HttpServletRequest request) {
        return new User(request.getParameter(FIRST_NAME),
                request.getParameter(LAST_NAME),
                request.getParameter(EMAIL),
                BCrypt.hashpw(request.getParameter(PASSWORD),BCrypt.gensalt()),
                new Wallet());
    }

}
