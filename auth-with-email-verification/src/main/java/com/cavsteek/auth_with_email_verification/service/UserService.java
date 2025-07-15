package com.cavsteek.auth_with_email_verification.service;

import com.cavsteek.auth_with_email_verification.model.User;
import com.cavsteek.auth_with_email_verification.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

//    public List<User> AllUsers(){
//        List<User> users = new ArrayList<>();
//        userRepo.findAll().forEach(users::add);
//        return users;
//    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }
}
