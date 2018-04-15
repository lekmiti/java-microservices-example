package com.lekmiti.users.services;

import com.lekmiti.users.UserApplication;
import com.lekmiti.users.domain.User;
import com.lekmiti.users.dtos.UserDto;
import com.lekmiti.users.persistence.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.lekmiti.users.DataFactory.aUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @MockBean
    UserRepository userRepository;


    @Test
    public void should_load_application_context() throws Exception {
        assertThat(userService).isNotNull();

    }

    @Test
    public void should_return_the_user_if_it_exists_in_the_database() throws Exception {
        //  Given
        User user = aUser("user@zsof-consulting.com", "user");
        when(userRepository.findUserByMailAndPassword(any(), any())).thenReturn(Optional.of(user));

        //  When
        Optional<UserDto> maybeUserDto = userService.getUser("user@zsof-consulting.com", "user");

        //  Then
        assertThat(maybeUserDto)
                .isPresent()
                .isEqualTo(Optional.of(user.mapToDto()));
    }

    @Test
    public void should_return_null_if_it_does_not_exists_in_the_database() throws Exception {
        //  Given
        when(userRepository.findUserByMailAndPassword(any(), any())).thenReturn(Optional.ofNullable(null));

        //  When
        Optional<UserDto> maybeUserDto = userService.getUser(any(), any());

        //  Then
        assertThat(maybeUserDto).isNotPresent();
    }

    @Test
    public void should_return_true_when_the_user__exists_the_database() throws Exception {
        //  Given
        User user = aUser("user@zsof-consulting.com", "user");
        when(userRepository.findUserByMailAndPassword(any(), any())).thenReturn(Optional.of(user));

        //  When
        Boolean exist = userService.isUserExist("user@zsof-consulting.com", "user");

        //  Then
        assertThat(exist).isTrue();
    }

    @Test
    public void should_return_false_when_the_user_does_not_exist_the_database() throws Exception {
        //  Given
        when(userRepository.findUserByMailAndPassword(any(), any())).thenReturn(Optional.ofNullable(null));

        //  When
        Boolean exist = userService.isUserExist(any(), any());

        //  Then
        assertThat(exist).isFalse();
    }


}