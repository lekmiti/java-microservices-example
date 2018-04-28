package com.lekmiti.users.rest;

import com.lekmiti.users.UserApplication;
import com.lekmiti.users.dtos.UserDto;
import com.lekmiti.users.persistence.UserRepository;
import com.lekmiti.users.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static com.lekmiti.users.DataFactory.aUserDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(UserResource.class)
public class UserResourceTest {

    @MockBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;                        

    @Test
    public void should_load_application_contzext() throws Exception {
        assertThat(this.userService).isNotNull();
        assertThat(this.userRepository).isNotNull();
        assertThat(this.mockMvc).isNotNull();
    }

    @Test
    public void should_return_http_status_200_when_user_is_found() throws Exception {
        //  Given
        UserDto aUserDto = aUserDto("mail");
        given(this.userService.getUser("mail", "password")).willReturn(Optional.of(aUserDto));


        // When-Then
        this.mockMvc
                .perform(post("/rest/users")
                        .param("login","mail")
                        .param("password","password")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_return_http_status_404_when_user_is_not_found() throws Exception {
        //  Given
        given(this.userService.getUser("mail", "password")).willReturn(Optional.ofNullable(null));

        //  When-Then
        this.mockMvc
                .perform(post("/rest/users")
                        .param("login","mail")
                        .param("password","password")
                        .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isNotFound());
    }

}