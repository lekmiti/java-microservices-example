package com.lekmiti.users.persistence;

import com.lekmiti.users.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByMailAndPassword(String mail, String password);
}
