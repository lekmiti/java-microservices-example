package com.lekmiti.users.rest;

import com.lekmiti.users.dtos.UserDto;
import com.lekmiti.users.services.UserService;
 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/rest")
public class UserResource {

    private UserService userService;

    @Autowired
    public UserResource(UserService userService) {
        this.userService = userService;
    }

    private final Logger log = LoggerFactory.getLogger(UserResource.class);


    @PostMapping ("/users")
    public ResponseEntity<UserDto> getUser(String login,  String password) {
        log.debug("REST request to get User : {}", login);
        return  userService.getUser(login, password)
                 .map(userDto -> ResponseEntity.ok(userDto))
                 .orElseGet(() -> ResponseEntity.notFound().build());
     }



}
