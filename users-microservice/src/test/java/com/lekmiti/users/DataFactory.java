package com.lekmiti.users;

import com.lekmiti.users.domain.User;
import com.lekmiti.users.dtos.UserDto;

public class DataFactory {

    public static User aUser(String mail, String password) {
        return new User(mail, password, null, null);
    }

    public static UserDto aUserDto(String mail) {
        return new UserDto(mail, null, null);
    }
}
