package vn.project.web_sale_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.project.web_sale_book.entity.User;
import vn.project.web_sale_book.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @CrossOrigin(origins = "http://localhost:5174")
    @PostMapping("/signup")
    public ResponseEntity<?> signUpUserResponse(@Validated @RequestBody User user) {
        ResponseEntity<?> response = accountService.signUpUser(user);
        return response;
    }
}
