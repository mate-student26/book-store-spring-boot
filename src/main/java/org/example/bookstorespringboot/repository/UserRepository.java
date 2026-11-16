package org.example.bookstorespringboot.repository;

import java.util.Optional;
import org.example.bookstorespringboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
