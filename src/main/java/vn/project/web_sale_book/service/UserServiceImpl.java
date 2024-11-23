package vn.project.web_sale_book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.project.web_sale_book.dao.RoleRepository;
import vn.project.web_sale_book.dao.UserRepository;
import vn.project.web_sale_book.entity.User;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User users = userRepository.findByUsername(username);
//        if (users == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        User user = new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword());
//
//    }
}
