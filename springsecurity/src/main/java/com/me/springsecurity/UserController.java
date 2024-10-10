package com.me.springsecurity;

import java.util.List;
import com.me.springsecurity.model.MyUser;
import com.me.springsecurity.model.MyUserDetailService;
import com.me.springsecurity.model.UserRepository;
import com.me.springsecurity.token.JWTService;
import com.me.springsecurity.token.LoginForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @PostMapping("/addUser")
    public MyUser addUser(@RequestBody MyUser user) {
        return userRepo.save(user);
    }

    @GetMapping("/getAllUser")
    public List<MyUser> getAllUser(){
        return userRepo.findAll();
    }
}
