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

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new User("mail1", "password1", "Jack", "Bauer"));
            repository.save(new User("mail2", "password1", "Chloe", "O'Brian"));
            repository.save(new User("mail3", "password1", "Kim", "Bauer"));

// fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            repository.findById(1L)
                    .ifPresent(customer -> {
                        log.info("Customer found with findById(1L):");
                        log.info("--------------------------------");
                        log.info(customer.toString());
                        log.info("");
                    });


        };
    }


}
