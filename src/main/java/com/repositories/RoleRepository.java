package com.repositories;
import com.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Created by aleksei on 23.01.17.
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}