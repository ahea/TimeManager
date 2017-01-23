package com.models;

import javax.persistence.*;
import java.util.Collection;
/**
 * Created by aleksei on 23.01.17.
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<User> getUsers() {
            return users;
    }

    public void setUsers(Collection<User> users) {
            this.users = users;
    }
}

