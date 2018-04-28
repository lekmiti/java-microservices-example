package com.lekmiti.users;

import com.lekmiti.users.domain.User;
import com.lekmiti.users.persistence.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class UserApplication {
    private static final Logger log = LoggerFactory.getLogger(UserApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

    }

}
