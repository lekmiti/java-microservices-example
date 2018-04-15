package com.lekmiti.users.services;

import com.lekmiti.users.dtos.UserDto;
import com.lekmiti.users.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    UserRepository userRepository;

    @Autowired
    public  UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public Boolean isUserExist(String mail, String password){
        return getUser(mail,password).isPresent();
     }

    public Optional<UserDto> getUser(String mail, String password){
        return userRepository.findUserByMailAndPassword(mail,password).map(user -> user.mapToDto());
     }

}
