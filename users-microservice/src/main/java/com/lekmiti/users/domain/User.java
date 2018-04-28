package com.lekmiti.users.domain;

import com.lekmiti.users.dtos.UserDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// todo: see why lombok's annotations do not work
@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@Entity(name = "dsqd")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    @Size(max = 100)
    private String mail;

    @NotNull
    @Size(max = 100)

    private String password;

    @Column(name = "first_name")
    @Size(max = 50)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 50)
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

    // todo: to be refactored using an automatic mapper
    public UserDto mapToDto(){
        UserDto userDto = new UserDto();
        userDto.setFirstName(this.firstName);
        userDto.setLastName(this.lastName);
        userDto.setMail(this.password);
        return userDto;
    }
}
