package com.lekmiti.users.persistence;

import com.lekmiti.users.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.lekmiti.users.DataFactory.aUser;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestEntityManager testEntityManager;


    @Test
    public void should_load_application_context() throws Exception {
        assertThat(userRepository).isNotNull();
        assertThat(testEntityManager).isNotNull();
    }

    @Test
    public void should_find_user_when_mail_and_password_are_given() {
        // Given
        User user = aUser("user@zsof-consulting.com", "user");
        testEntityManager.persist(user);
        testEntityManager.flush();

        // When
        Optional<User> userFromDb = userRepository.findUserByMailAndPassword("user@zsof-consulting.com", "user");

        // Then
        assertThat(userFromDb).isPresent();
        assertThat(userFromDb.get()).isEqualTo(user);
    }

}