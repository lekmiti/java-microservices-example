package com.lekmiti.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
 import lombok.experimental.Accessors;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@ToString
@Accessors
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private String mail;
    private String password;
    private String firstName;
    private String lastName;

    // for JPA's sake
    protected  User(){}



}
