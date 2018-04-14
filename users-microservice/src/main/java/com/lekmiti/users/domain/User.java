package com.lekmiti.users.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;


    // for JPA's sake
    protected User() {
    }

    public User(String mail, String password, String firstName, String lastName) {
        this.mail = mail;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
