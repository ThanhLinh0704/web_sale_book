package vn.project.web_sale_book.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import vn.project.web_sale_book.entity.User;


public interface UserService extends UserDetailsService {

    public User findByUsername(String username);

}
