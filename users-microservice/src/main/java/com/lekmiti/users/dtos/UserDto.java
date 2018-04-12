package com.lekmiti.users.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors
@AllArgsConstructor
public class UserDto {
        private String userName;
        private String firstName;
        private String lastName;
}
