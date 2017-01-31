package com.Preload;

import com.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.models.Role;

/**
 * Created by aleksei on 23.01.17.
 */

@Component
public class RolesPreloader implements ApplicationListener<ContextRefreshedEvent> {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        createRole("USER");
        createRole("ADMIN");
    }

    @Transactional
    private Role createRole(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null){
            role = new Role();
            role.setName(name);
            roleRepository.save(role);
        }
        return role;
    }

}
