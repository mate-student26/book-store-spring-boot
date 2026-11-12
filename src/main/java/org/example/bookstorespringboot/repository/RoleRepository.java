package org.example.bookstorespringboot.repository;

import java.util.Optional;
import org.example.bookstorespringboot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByName(Role.RoleName name);
}
