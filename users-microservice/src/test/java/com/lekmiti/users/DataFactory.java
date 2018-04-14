package com.lekmiti.users;

import com.lekmiti.users.domain.User;

public class DataFactory {

    public static User aUser(String mail, String password) {
        return new User(mail, password, null, null);
    }
}
