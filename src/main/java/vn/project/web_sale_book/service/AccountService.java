package vn.project.web_sale_book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vn.project.web_sale_book.dao.UserRepository;
import vn.project.web_sale_book.entity.Announce;
import vn.project.web_sale_book.entity.User;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> signUpUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return ResponseEntity.badRequest().body(new Announce("Username already exists"));
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.badRequest().body(new Announce("Email already exists"));
        }

        userRepository.save(user);
        return ResponseEntity.ok().body(new Announce("User created"));
    }
}
